package com.example.BookMyTicket.model.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {
    private Integer bookingId;
    private String username;
    private Double price;
    private Boolean success;
    private Long showStartTime;
    private Long showEndTime;
    private String movieName;
}
