package com.example.BookMyTicket.model.response;

import com.example.BookMyTicket.entities.Show;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShowsResponse {
    private List<Show> shows;

}
