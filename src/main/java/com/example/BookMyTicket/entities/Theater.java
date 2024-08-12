package com.example.BookMyTicket.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// this is a table entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Theater {
    private int id;
    private String theaterName;
    private String address;
    private Integer cityId;
}
