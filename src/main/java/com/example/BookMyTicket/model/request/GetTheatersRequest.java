package com.example.BookMyTicket.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetTheatersRequest {
    private Integer movieId;
    private Integer cityId;
}
