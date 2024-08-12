package com.example.BookMyTicket.Utils;

import com.example.BookMyTicket.entities.Seat;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class SeatUtils {

    List<Seat> seats = new ArrayList<>();
    static {
        seats.add(new Seat(1, 1, "A1"));
        seats.add(new Seat(2, 1, "A2"));
        seats.add(new Seat(3, 1, "A3"));
        seats.add(new Seat(4, 2, "B1"));
        seats.add(new Seat(5, 2, "B2"));
        seats.add(new Seat(6, 2, "B3"));
        seats.add(new Seat(7, 3, "C1"));
        seats.add(new Seat(8, 3, "C2"));
        seats.add(new Seat(9, 3, "C3"));
        seats.add(new Seat(10, 4, "D1"));
    }
}
