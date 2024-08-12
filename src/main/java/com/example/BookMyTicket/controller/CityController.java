package com.example.BookMyTicket.controller;

import com.example.BookMyTicket.entities.City;
import com.example.BookMyTicket.entities.Movie;
import com.example.BookMyTicket.entities.Theater;
import com.example.BookMyTicket.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/v1")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/cities")
    public ResponseEntity<List<City>> getCities() {
        List<City> cities = new ArrayList<>();
        try {
            cities = cityService.getAllCities();
        } catch (Exception e) {
            log.error("Exception occurred while fetching cities, {}", ExceptionUtils.getStackTrace(e));
        }
        return ResponseEntity.ok(cities);
    }
}
