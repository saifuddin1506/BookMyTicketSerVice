package com.example.BookMyTicket.service;

import com.example.BookMyTicket.Utils.MovieUtils;
import com.example.BookMyTicket.entities.Movie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class MovieService {

    public List<Movie> getAllMoviesByMovieIds(List<Integer> movieIds) {
        if (CollectionUtils.isEmpty(movieIds)) {
            return new ArrayList<>();
        }
        return movieIds.stream().map(id -> MovieUtils.movieIdToMovieMap.getOrDefault(id, null)).filter(Objects::nonNull).toList();
    }
}
