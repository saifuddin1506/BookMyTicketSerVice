package com.example.BookMyTicket.handler;

import com.example.BookMyTicket.model.request.ShowsRequest;
import com.example.BookMyTicket.model.response.ShowSeatsResponse;
import com.example.BookMyTicket.model.response.ShowsResponse;
import com.example.BookMyTicket.service.ShowSeatsService;
import com.example.BookMyTicket.service.ShowService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
public class ShowsRequestHandler {
    private final ShowService showService;
    private final ShowSeatsService showSeatsService;

    public ShowsRequestHandler(ShowService showService, ShowSeatsService showSeatsService) {
        this.showService = showService;
        this.showSeatsService = showSeatsService;
    }

    public ShowsResponse getShowResponseByMovieAndTheaterId(ShowsRequest showsRequest) throws BadRequestException {
        if (!validateRequest(showsRequest)) {
            throw new BadRequestException("movie id or theatre id is null");
        }
        return ShowsResponse.builder()
                .shows(showService.getAllShowsByMovieIdAndTheatreId(showsRequest.getMovieId(), showsRequest.getTheatreId()))
                .build();
    }

    public ShowSeatsResponse getShowSeatsResponse(Integer showId) throws BadRequestException {
        return ShowSeatsResponse.builder()
                .showSeats(showSeatsService.getAllAvailableShowSeats(showId))
                .build();
    }

    private boolean validateRequest(ShowsRequest showsRequest){
        return Objects.nonNull(showsRequest) && Objects.nonNull(showsRequest.getTheatreId()) && Objects.nonNull(showsRequest.getMovieId());
    }
}
