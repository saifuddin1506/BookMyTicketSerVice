package com.example.BookMyTicket.service;

import com.example.BookMyTicket.Utils.CityUtils;
import com.example.BookMyTicket.entities.City;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class CityService {
    //get all cities
    public List<City> getAllCities(){
        log.info("trying to get all cities");
        return CityUtils.cities;
    }

    public City getCityById(Integer id) throws BadRequestException {
        if (Objects.isNull(id)) {
            log.info("id is null");
            throw new BadRequestException(" id can not be null");
        }
        return CityUtils.cities.stream().filter(city -> city.getId() == id).findFirst().orElse(null);
    }
}
