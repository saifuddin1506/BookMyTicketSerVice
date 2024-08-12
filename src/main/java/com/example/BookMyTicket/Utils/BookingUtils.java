package com.example.BookMyTicket.Utils;

import com.example.BookMyTicket.entities.Booking;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
@Slf4j
public class BookingUtils {
    public static List<Booking> bookings = new ArrayList<>();

    public static void saveBooking(Booking booking) {
        bookings.add(booking);
    }

    public static void showBookings() {
        for (Booking booking : bookings) {
            log.info(" booking : {}", booking);
        }
    }
}
