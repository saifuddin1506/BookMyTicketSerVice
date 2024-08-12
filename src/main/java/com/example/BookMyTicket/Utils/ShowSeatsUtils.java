package com.example.BookMyTicket.Utils;

import com.example.BookMyTicket.enums.SeatStatus;
import com.example.BookMyTicket.entities.ShowSeats;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class ShowSeatsUtils {
    public static List<ShowSeats> showSeatsList = new ArrayList<>();
    public static Map<Integer , List<ShowSeats>> showIdToSeatsMap = new HashMap<>();
    public static Map<Integer , ShowSeats> seatIdToShowSeatsMap = new HashMap<>();
    public static Map<Integer , ShowSeats> showSeatIdToShowSeatsMap = new HashMap<>();

    static {
        showSeatsList.add(new ShowSeats(1, 1, SeatStatus.AVAILABLE, 1));
        showSeatsList.add(new ShowSeats(2, 2, SeatStatus.AVAILABLE, 1));
        showSeatsList.add(new ShowSeats(3, 3, SeatStatus.AVAILABLE, 1));
        showSeatsList.add(new ShowSeats(4, 4, SeatStatus.AVAILABLE, 2));
        showSeatsList.add(new ShowSeats(5, 5, SeatStatus.AVAILABLE, 2));
        showSeatsList.add(new ShowSeats(6, 6, SeatStatus.AVAILABLE, 2));
        showSeatsList.add(new ShowSeats(7, 7, SeatStatus.AVAILABLE, 3));
        showSeatsList.add(new ShowSeats(8, 8, SeatStatus.AVAILABLE, 3));
        showSeatsList.add(new ShowSeats(9, 9, SeatStatus.AVAILABLE, 3));
        showSeatsList.add(new ShowSeats(10, 10, SeatStatus.AVAILABLE, 4));
        for (ShowSeats showSeats : showSeatsList) {
            List<ShowSeats> seats = showIdToSeatsMap.getOrDefault(showSeats.getShowId(), new ArrayList<>());
            seats.add(showSeats);
            showIdToSeatsMap.put(showSeats.getShowId(), seats);
            seatIdToShowSeatsMap.put(showSeats.getSeatId(),showSeats);
            showSeatIdToShowSeatsMap.put(showSeats.getId(),showSeats);
        }
    }

    public static void markSeatsUnAvailable(List<ShowSeats> seats) {
        for (ShowSeats showSeats : seats) {
            showSeatsList.get(showSeats.getId()-1).setSeatStatus(SeatStatus.UNAVAILABLE);
            showSeatIdToShowSeatsMap.get(showSeats.getId()).setSeatStatus(SeatStatus.UNAVAILABLE);
            seatIdToShowSeatsMap.get(showSeats.getSeatId()).setSeatStatus(SeatStatus.UNAVAILABLE);
        }
    }


}
