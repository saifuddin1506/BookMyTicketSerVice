package com.example.BookMyTicket.service;

import com.example.BookMyTicket.model.request.BookingRequest;
import com.example.BookMyTicket.model.response.BookingResponse;
import org.apache.coyote.BadRequestException;

public interface BookingService {
    BookingResponse bookTicket(BookingRequest bookingRequest) throws BadRequestException;
}
