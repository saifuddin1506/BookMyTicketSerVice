package com.example.BookMyTicket.entities;

import com.example.BookMyTicket.enums.BookingStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    private int id;
    private String username;
    private String phoneNumber;
    private Double price;
    private BookingStatus bookingStatus;
    private Integer seatId;
    private Integer showId;
    private Integer theaterId;
    private String showName;
}
