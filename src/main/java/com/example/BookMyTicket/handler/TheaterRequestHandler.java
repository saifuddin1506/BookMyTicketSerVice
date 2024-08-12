package com.example.BookMyTicket.handler;


import com.example.BookMyTicket.Utils.TheaterUtils;
import com.example.BookMyTicket.entities.Theater;
import com.example.BookMyTicket.model.request.GetTheatersRequest;
import com.example.BookMyTicket.service.TheaterService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class TheaterRequestHandler {
    private final TheaterService theaterService;

    public TheaterRequestHandler(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    public List<Theater> getTheatersByCityAndMovieId(GetTheatersRequest request) throws BadRequestException {
        if (Objects.isNull(request) || Objects.isNull(request.getCityId()) || Objects.isNull(request.getMovieId())) {
            throw new BadRequestException(" null request received");
        }
        return theaterService.getAllTheatersByMovieIdAndCityId(request.getMovieId(), request.getCityId());
    }
    public List<Theater> getAllTheaterByCityId(Integer cityId) throws BadRequestException {
        if (Objects.isNull(cityId)) {
            throw new BadRequestException("city id can not be null");
        }
        return TheaterUtils.cityIdToTheatreMap.getOrDefault(cityId, new ArrayList<>());
    }

}
