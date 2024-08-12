package com.example.BookMyTicket.service;

import com.example.BookMyTicket.Utils.ShowSeatsUtils;
import com.example.BookMyTicket.entities.ShowSeats;
import com.example.BookMyTicket.enums.SeatStatus;
import com.example.BookMyTicket.model.response.ShowsResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ShowSeatsService {

    public List<ShowSeats> getAllAvailableShowSeats(Integer showId) throws BadRequestException {
        if (Objects.isNull(showId)) {
            throw new BadRequestException("show id can not be null");
        }
        return ShowSeatsUtils.showIdToSeatsMap.getOrDefault(showId, new ArrayList<>()).stream().filter(showSeats -> showSeats.getSeatStatus()==SeatStatus.AVAILABLE).toList();
    }

    public ShowSeats getShowSeatsBySeatId(Integer seatId) throws BadRequestException {
        if (Objects.isNull(seatId)) {
            throw new BadRequestException("seat id can not be null");
        }
        ShowSeats showSeats = ShowSeatsUtils.seatIdToShowSeatsMap.getOrDefault(seatId, null);
        if (Objects.isNull(showSeats)) {
            throw new RuntimeException("seat not found");
        }
        return showSeats;
    }
    public void markSeatsUnavailable(List<ShowSeats>seats){

    }

}
