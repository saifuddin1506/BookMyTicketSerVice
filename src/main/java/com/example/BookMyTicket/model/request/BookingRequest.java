package com.example.BookMyTicket.model.request;

import com.example.BookMyTicket.entities.Seat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingRequest {
    private String userName;
    private Long userId;
    private Integer showId;
    private Integer theaterId;
    private List<Seat> seats;
}
