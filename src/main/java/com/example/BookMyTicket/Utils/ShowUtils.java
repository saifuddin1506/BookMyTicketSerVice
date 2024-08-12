package com.example.BookMyTicket.Utils;

import com.example.BookMyTicket.entities.Show;
import com.example.BookMyTicket.entities.Theater;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class ShowUtils {
    public static List<Show> showList = new ArrayList<>();
    public static Map<Integer , Show> showIdtoShowMap = new HashMap<>();
    public static Map<Integer,List<Integer> > movieIdToTheaterIdMap = new HashMap<>();
    public static Map<Integer , List<Show>> theaterIdToShowMap = new HashMap<>();
    static {
        showList.add(new Show(1, "Avengers: Endgame - 1", 1, 1, System.currentTimeMillis()+ 3600000, System.currentTimeMillis() + 7200000,10d));
        showList.add(new Show(2, "Inception - 1", 2, 1, System.currentTimeMillis() + 10800000, System.currentTimeMillis() + 14400000,20d));
        showList.add(new Show(3, "The Matrix - 1", 3, 2, System.currentTimeMillis() + 18000000, System.currentTimeMillis() + 21600000, 30d));
        showList.add(new Show(4, "Interstellar - 1", 4, 2, System.currentTimeMillis() + 25200000, System.currentTimeMillis() + 28800000, 40d));
        showList.add(new Show(5, "The Dark Knight - 1", 5, 3, System.currentTimeMillis() + 32400000, System.currentTimeMillis() + 36000000, 50d));
        showList.add(new Show(6, "Pulp Fiction - 1", 6, 3, System.currentTimeMillis() + 39600000, System.currentTimeMillis() + 43200000, 60d));
        showList.add(new Show(7, "Fight Club - 1", 7, 4, System.currentTimeMillis() + 46800000, System.currentTimeMillis() + 50400000, 70d));
        showList.add(new Show(8, "Forrest Gump - 1", 8, 4, System.currentTimeMillis() + 54000000, System.currentTimeMillis() + 57600000, 80d));
        showList.add(new Show(9, "The Shawshank Redemption - 1", 9, 5, System.currentTimeMillis() + 61200000, System.currentTimeMillis() + 64800000, 90d));
        showList.add(new Show(10, "Jurassic Park - 1", 10, 5, System.currentTimeMillis() + 68400000, System.currentTimeMillis() + 72000000, 100d));
        for(Show show : showList){
            showIdtoShowMap.put(show.getId(), show);
            theaterIdToShowMap.computeIfAbsent(show.getTheatreId(), k -> new ArrayList<>()).add(show);
            movieIdToTheaterIdMap.computeIfAbsent(show.getMovieId(),k-> new ArrayList<>()).add(show.getTheatreId());
        }
    }
}
