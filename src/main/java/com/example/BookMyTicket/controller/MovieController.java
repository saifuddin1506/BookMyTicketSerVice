package com.example.BookMyTicket.controller;


import com.example.BookMyTicket.entities.Movie;
import com.example.BookMyTicket.handler.MovieRequestHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class MovieController {
    private final MovieRequestHandler movieRequestHandler;

    public MovieController(MovieRequestHandler movieRequestHandler) {
        this.movieRequestHandler = movieRequestHandler;
    }

    @GetMapping("/movie-by-theater/{theatreId}")
    public ResponseEntity<List<Movie>> getAllMoviesByTheatreId(@PathVariable Integer theatreId) {
        HttpStatus httpStatus = HttpStatus.OK;
        List<Movie> movies = new ArrayList<>();
        try {
            movies = movieRequestHandler.getMoviesRunningInTheatre(theatreId);
        } catch (BadRequestException e){
            log.info("bad request Exception while getting movies by theaterId: {}", ExceptionUtils.getStackTrace(e));
            httpStatus=HttpStatus.BAD_REQUEST;
        } catch (Exception e ){
            log.info("exception occurred while fetching movies by theater id : {} {}", theatreId, ExceptionUtils.getStackTrace(e));
            httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(httpStatus.value()).body(movies);
    }

    @GetMapping("/movies/{cityId}")
    public ResponseEntity<List<Movie>> getMoviesRunningInCity(@PathVariable Integer cityId){
        HttpStatus httpStatus = HttpStatus.OK;
        List<Movie> movies = new ArrayList<>();
        try {
            movies = movieRequestHandler.getMoviesRunningInCity(cityId);
        } catch (BadRequestException e){
            log.info("bad request Exception: {}", ExceptionUtils.getStackTrace(e));
            httpStatus=HttpStatus.BAD_REQUEST;
        } catch (Exception e ){
            log.info("exception occurred while fetching movies by cityId : {} {}", cityId, ExceptionUtils.getStackTrace(e));
            httpStatus=HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return ResponseEntity.status(httpStatus.value()).body(movies);
    }
}
