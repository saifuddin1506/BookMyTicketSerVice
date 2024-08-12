package com.example.BookMyTicket.controller;


import com.example.BookMyTicket.handler.ShowsRequestHandler;
import com.example.BookMyTicket.model.request.ShowsRequest;
import com.example.BookMyTicket.model.response.ShowSeatsResponse;
import com.example.BookMyTicket.model.response.ShowsResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping("/v1")
public class ShowController {
    private final ShowsRequestHandler showsRequestHandler;

    public ShowController(ShowsRequestHandler showsRequestHandler) {
        this.showsRequestHandler = showsRequestHandler;
    }

    @GetMapping("/shows")
    public ResponseEntity<ShowsResponse> getAllShowsByMovieAndTheatreId(@RequestBody ShowsRequest showsRequest) {
        ShowsResponse response = null;
        HttpStatus httpStatus = HttpStatus.OK;
        try {
            response = showsRequestHandler.getShowResponseByMovieAndTheaterId(showsRequest);
        } catch (BadRequestException e) {
            log.error("bad request exception occurred for request : {} , {}", showsRequest, ExceptionUtils.getStackFrames(e));
            httpStatus = HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            log.error("exception occurred for request : {} , {}", showsRequest, ExceptionUtils.getStackFrames(e));
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(httpStatus.value()).body(response);
    }

    @GetMapping("/showSeats/{showId}")
    public ResponseEntity<ShowSeatsResponse> getShowSeats(@PathVariable Integer showId) {
        HttpStatus httpStatus = HttpStatus.OK;
        ShowSeatsResponse response = null;
        try {
            response = showsRequestHandler.getShowSeatsResponse(showId);
        } catch (BadRequestException e) {
            log.info("Bad request Exception occurred for showId : {}", showId);
            httpStatus = HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            log.error("Exception occurred while getting available seats, {}", ExceptionUtils.getStackTrace(e));
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(httpStatus.value()).body(response);
    }
}
