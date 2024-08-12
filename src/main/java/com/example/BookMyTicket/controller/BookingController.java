package com.example.BookMyTicket.controller;

import com.example.BookMyTicket.handler.BookingRequestHandler;
import com.example.BookMyTicket.model.request.BookingRequest;
import com.example.BookMyTicket.model.response.BookingResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/v1")
public class BookingController {
    private final BookingRequestHandler bookingRequestHandler;

    public BookingController(BookingRequestHandler bookingRequestHandler) {
        this.bookingRequestHandler = bookingRequestHandler;
    }

    @PostMapping("/book/movie")
    public ResponseEntity<BookingResponse> getAllMoviesByTheatreId(@RequestBody BookingRequest bookingRequest) {
        HttpStatus httpStatus = HttpStatus.OK;
       BookingResponse bookingResponse= null;
        try {
            bookingResponse = bookingRequestHandler.bookTicket(bookingRequest);
        } catch (BadRequestException e){
            log.info("bad request Exception: {}", ExceptionUtils.getStackTrace(e));
            httpStatus=HttpStatus.BAD_REQUEST;
        } catch (Exception e ){
            log.info("exception occurred while booking movie for request : {} {}", bookingRequest, ExceptionUtils.getStackTrace(e));
            httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(httpStatus.value()).body(bookingResponse);
    }
}
