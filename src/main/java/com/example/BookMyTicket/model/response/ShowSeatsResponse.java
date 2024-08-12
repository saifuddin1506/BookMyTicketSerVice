package com.example.BookMyTicket.model.response;

import com.example.BookMyTicket.entities.ShowSeats;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShowSeatsResponse {
    private List<ShowSeats> showSeats;
}
