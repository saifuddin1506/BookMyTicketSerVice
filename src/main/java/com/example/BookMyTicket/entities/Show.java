package com.example.BookMyTicket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Show {
    private int id;
    private String showName; // movie name
    private Integer movieId;
    private Integer theatreId;
    private long start;
    private long end;
    private Double pricePerSeat;
}
