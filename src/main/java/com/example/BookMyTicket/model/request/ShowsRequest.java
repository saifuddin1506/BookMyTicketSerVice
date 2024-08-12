package com.example.BookMyTicket.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShowsRequest {
    private Integer movieId;
    private Integer theatreId;
    //more fields can be added such as filters, no of shows to fetch
}
