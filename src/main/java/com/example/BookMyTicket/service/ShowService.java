package com.example.BookMyTicket.service;

import com.example.BookMyTicket.Utils.ShowUtils;
import com.example.BookMyTicket.entities.Show;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ShowService {
    
    public List<Show> getAllShowsByTheatreId(Integer theatreId) throws BadRequestException {
        if (Objects.isNull(theatreId)) {
            throw new BadRequestException("theater id can not be null");
        }
        try {
            return ShowUtils.showList.stream().filter(show -> show.getTheatreId().equals(theatreId)).collect(Collectors.toList());
        } catch (Exception e) {
            log.info("Exception occurred while fetching shows by theater id : {}, {}", theatreId, ExceptionUtils.getStackTrace(e));
        }
        return new ArrayList<>();
    }

    public List<Show> getAllShowsByMovieIdAndTheatreId(Integer movieId, Integer theaterId) throws BadRequestException {
        if (Objects.isNull(movieId)) {
            throw new BadRequestException("movie id can not be null");
        }
        try {
            return ShowUtils.showList.stream().filter(show -> show.getMovieId().equals(movieId) && show.getTheatreId() == theaterId).collect(Collectors.toList());
        } catch (Exception e) {
            log.info("Exception occurred while fetching shows by movie id , {} , {}",movieId, ExceptionUtils.getStackTrace(e));
        }
        return new ArrayList<>();
    }
}
