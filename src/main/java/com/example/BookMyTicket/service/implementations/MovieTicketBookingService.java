package com.example.BookMyTicket.service.implementations;

import com.example.BookMyTicket.Utils.BookingUtils;
import com.example.BookMyTicket.Utils.ShowSeatsUtils;
import com.example.BookMyTicket.Utils.ShowUtils;
import com.example.BookMyTicket.entities.Booking;
import com.example.BookMyTicket.entities.Seat;
import com.example.BookMyTicket.entities.Show;
import com.example.BookMyTicket.entities.ShowSeats;
import com.example.BookMyTicket.enums.BookingStatus;
import com.example.BookMyTicket.enums.SeatStatus;
import com.example.BookMyTicket.model.request.BookingRequest;
import com.example.BookMyTicket.model.response.BookingResponse;
import com.example.BookMyTicket.service.BookingService;
import com.example.BookMyTicket.service.ShowSeatsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MovieTicketBookingService implements BookingService {
    private final ShowSeatsService showSeatsService;

    public MovieTicketBookingService(ShowSeatsService showSeatsService) {
        this.showSeatsService = showSeatsService;
    }

    @Override
    public BookingResponse bookTicket(BookingRequest bookingRequest) throws BadRequestException {
      List<Seat> seats = bookingRequest.getSeats();
      BookingResponse bookingResponse = BookingResponse.builder().build();
        List<ShowSeats> showSeats = seats.stream().map(seat -> {
            try {
                return showSeatsService.getShowSeatsBySeatId(seat.getId());
            } catch (BadRequestException e) {
                throw new RuntimeException(e);
            }
        }).toList();
        if(!checkIfSeatsAvailableAndMarkUnavailable(showSeats)){
            bookingResponse.setSuccess(false);
            return bookingResponse;
        }
        Show show = ShowUtils.showIdtoShowMap.get(bookingRequest.getShowId());
        Booking booking = saveBooking(seats.size(), bookingRequest, show);
        bookingResponse.setShowEndTime(show.getEnd());
        bookingResponse.setSuccess(true);
        bookingResponse.setShowStartTime(show.getStart());
        bookingResponse.setBookingId(booking.getId());
        bookingResponse.setUsername(booking.getUsername());
        bookingResponse.setPrice(booking.getPrice());
        bookingResponse.setMovieName(show.getShowName());
        return bookingResponse;
    }

    private boolean checkIfSeatsAvailableAndMarkUnavailable(List<ShowSeats> seats) {
        for (ShowSeats showSeats : seats) {
            if (showSeats.getSeatStatus() != SeatStatus.AVAILABLE) {
                return false;
            }
        }
        ShowSeatsUtils.markSeatsUnAvailable(seats);
        return true;
    }
    private Booking saveBooking(Integer numberOfSeats, BookingRequest bookingRequest, Show show){
        Double pricePerSeat = show.getPricePerSeat();
        Booking booking = new Booking();
        booking.setId(BookingUtils.bookings.size()+1);
        booking.setPrice(pricePerSeat * numberOfSeats);
        booking.setBookingStatus(BookingStatus.SUCCESSFUL);
        booking.setTheaterId(bookingRequest.getTheaterId());
        booking.setUsername(bookingRequest.getUserName());
        booking.setShowName(show.getShowName());
        BookingUtils.saveBooking(booking);
        BookingUtils.showBookings();
        return booking;
    }
}
