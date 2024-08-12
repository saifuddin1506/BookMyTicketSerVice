package com.example.BookMyTicket.entities;

import com.example.BookMyTicket.enums.SeatStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowSeats {
    private Integer id;
    private Integer seatId;
    private SeatStatus seatStatus;
    private Integer showId;
}
