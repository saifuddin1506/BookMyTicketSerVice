package com.example.BookMyTicket.service;

import com.example.BookMyTicket.Utils.ShowUtils;
import com.example.BookMyTicket.Utils.TheaterUtils;
import com.example.BookMyTicket.entities.Theater;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class TheaterService {
    public List<Theater> getAllTheatersByCityId(Integer cityId) {
        return TheaterUtils.cityIdToTheatreMap.getOrDefault(cityId, new ArrayList<>());
    }

    public List<Theater> getAllTheatersByMovieIdAndCityId(Integer movieId,Integer cityId){
        List<Integer> theaterIds = ShowUtils.movieIdToTheaterIdMap.getOrDefault(movieId, new ArrayList<>());
        List<Theater> theaters = new ArrayList<>();
        for(Integer id : theaterIds){
           theaters.add(TheaterUtils.theaterIdToTheaterMap.getOrDefault(id,null));
        }
        return theaters.stream().filter(Objects::nonNull).filter(theater -> theater.getCityId().equals(cityId)).toList();
    }
}
