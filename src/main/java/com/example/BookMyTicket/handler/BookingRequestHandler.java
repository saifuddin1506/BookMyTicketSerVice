package com.example.BookMyTicket.handler;

import com.example.BookMyTicket.model.request.BookingRequest;
import com.example.BookMyTicket.model.response.BookingResponse;
import com.example.BookMyTicket.service.BookingService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Objects;

@Slf4j
@Component
public class BookingRequestHandler {
    private final BookingService bookingService;

    public BookingRequestHandler(BookingService bookingService) {
        this.bookingService = bookingService;
    }
    public BookingResponse bookTicket(BookingRequest bookingRequest) throws BadRequestException {
        BookingResponse response = null;
        if(!isValidRequest(bookingRequest)){
            throw new BadRequestException("bad request received");
        }
        return bookingService.bookTicket(bookingRequest);
    }

    private boolean isValidRequest(BookingRequest bookingRequest){
        return Objects.nonNull(bookingRequest) && Objects.nonNull(bookingRequest.getShowId())
                && !CollectionUtils.isEmpty(bookingRequest.getSeats())
                && Objects.nonNull(bookingRequest.getUserId())
                && Objects.nonNull(bookingRequest.getUserName());
    }

}
