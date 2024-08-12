package com.example.BookMyTicket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private int id;
    private String cityName;
    private String state;
    private String country;
}
