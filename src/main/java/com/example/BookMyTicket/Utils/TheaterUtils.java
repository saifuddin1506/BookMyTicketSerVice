package com.example.BookMyTicket.Utils;

import com.example.BookMyTicket.entities.Theater;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class TheaterUtils {
    public static List<Theater> theaters = new ArrayList<>();
    public static Map<Integer , List<Theater>> cityIdToTheatreMap = new HashMap<>();
    public static Map<Integer , Theater> theaterIdToTheaterMap = new HashMap<>();
    static {
        theaters.add(new Theater(1, "PVR Cinemas", "123 MG Road, Bangalore", 1));
        theaters.add(new Theater(2, "Inox Movies", "456 Brigade Road, Bangalore", 1));
        theaters.add(new Theater(3, "Cinepolis", "789 Phoenix Marketcity, Mumbai", 2));
        theaters.add(new Theater(4, "Big Cinemas", "101 Lower Parel, Mumbai", 2));
        theaters.add(new Theater(5, "Carnival Cinemas", "202 Marina Beach Road, Chennai", 3));
        theaters.add(new Theater(6, "Sathyam Cinemas", "303 Royapettah, Chennai", 3));
        theaters.add(new Theater(7, "PVR Cinemas", "404 Cyber Hub, Gurgaon", 4));
        theaters.add(new Theater(8, "INOX", "505 Connaught Place, Delhi", 5));
        theaters.add(new Theater(9, "Fun Cinemas", "606 Banjara Hills, Hyderabad", 6));
        theaters.add(new Theater(10, "MovieMax", "707 Baner, Pune", 7));
        for (Theater theater : theaters) {
            cityIdToTheatreMap.computeIfAbsent(theater.getCityId(), k -> new ArrayList<>()).add(theater);
            theaterIdToTheaterMap.put(theater.getId(), theater);
        }
    }
}
