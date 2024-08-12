package com.example.BookMyTicket.controller;

import com.example.BookMyTicket.entities.Movie;
import com.example.BookMyTicket.entities.Theater;
import com.example.BookMyTicket.handler.TheaterRequestHandler;
import com.example.BookMyTicket.model.request.GetTheatersRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class TheaterController {
    private final TheaterRequestHandler theaterRequestHandler;

    public TheaterController(TheaterRequestHandler theaterRequestHandler) {
        this.theaterRequestHandler = theaterRequestHandler;
    }

    @GetMapping("/theaters")
    public ResponseEntity<List<Theater>> getAllTheatersByMovieAndCityId(@RequestBody GetTheatersRequest theatersRequest) {
        HttpStatus httpStatus = HttpStatus.OK;
        List<Theater> theaters = new ArrayList<>();
        try {
            theaters = theaterRequestHandler.getTheatersByCityAndMovieId(theatersRequest);
        } catch (BadRequestException e){
            log.info("bad request Exception while getting theaters by request : {} : {}",theatersRequest, ExceptionUtils.getStackTrace(e));
            httpStatus=HttpStatus.BAD_REQUEST;
        } catch (Exception e ){
            log.info("exception occurred while fetching theaters request : {} {}", theatersRequest, ExceptionUtils.getStackTrace(e));
            httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(httpStatus.value()).body(theaters);
    }
    @GetMapping("/theaters/{cityId}")
    public ResponseEntity<List<Theater>> getAllTheatersByCityId(@PathVariable Integer cityId) {
        HttpStatus httpStatus = HttpStatus.OK;
        List<Theater> theaters = new ArrayList<>();
        try {
            theaters = theaterRequestHandler.getAllTheaterByCityId(cityId);
        } catch (BadRequestException e){
            log.info("bad request Exception while getting theaters by city id : {} : {}",cityId, ExceptionUtils.getStackTrace(e));
            httpStatus=HttpStatus.BAD_REQUEST;
        } catch (Exception e ){
            log.info("exception occurred while fetching theaters by city id : {} {}", cityId, ExceptionUtils.getStackTrace(e));
            httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(httpStatus.value()).body(theaters);
    }
}
