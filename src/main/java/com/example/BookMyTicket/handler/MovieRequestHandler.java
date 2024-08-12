package com.example.BookMyTicket.handler;

import com.example.BookMyTicket.Utils.MovieUtils;
import com.example.BookMyTicket.Utils.ShowUtils;
import com.example.BookMyTicket.Utils.TheaterUtils;
import com.example.BookMyTicket.entities.Movie;
import com.example.BookMyTicket.entities.Show;
import com.example.BookMyTicket.entities.Theater;
import com.example.BookMyTicket.service.MovieService;
import com.example.BookMyTicket.service.ShowService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Slf4j
public class MovieRequestHandler {
    private final ShowService showService;
    private final MovieService movieService;

    public MovieRequestHandler(ShowService showService, MovieService movieService) {
        this.showService = showService;
        this.movieService = movieService;
    }

    public List<Movie> getMoviesRunningInTheatre(Integer theaterId) throws BadRequestException {
        if (Objects.isNull(theaterId)) {
            throw new BadRequestException("theater id is null");
        }
        List<Show> runningShows = showService.getAllShowsByTheatreId(theaterId);
        List<Integer> movieIds = runningShows.stream().map(Show::getMovieId).toList();
        return movieService.getAllMoviesByMovieIds(movieIds);
    }

    public List<Movie> getMoviesRunningInCity(Integer cityId) throws BadRequestException {
        if (Objects.isNull(cityId)) {
            throw new BadRequestException("theater id is null");
        }
        List<Movie> movies = new ArrayList<>();
        List<Theater> theaters = TheaterUtils.cityIdToTheatreMap.getOrDefault(cityId, new ArrayList<>());
        for (Theater theater : theaters) {
            List<Show> shows = ShowUtils.theaterIdToShowMap.get(theater.getId());
            for (Show show : shows) {
                movies.add(MovieUtils.movieIdToMovieMap.getOrDefault(show.getMovieId(), null));
            }
        }
        return movies.stream().filter(Objects::nonNull).toList();
    }

}
