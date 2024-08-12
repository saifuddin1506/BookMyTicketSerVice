package com.example.BookMyTicket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {
    private int id;
    private Integer theaterId;
    private String seatName;
}
