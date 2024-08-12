package com.example.BookMyTicket.Utils;

import com.example.BookMyTicket.entities.Movie;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UtilityClass
public class MovieUtils {
    public static List<Movie> movies = new ArrayList<>();
    public static Map<Integer , Movie> movieIdToMovieMap =  new HashMap<>();
    static {
        Movie movie1 = new Movie();
        movie1.setId(1);
        movie1.setName("Avengers: Endgame");
        movies.add(movie1);

        Movie movie2 = new Movie();
        movie2.setId(2);
        movie2.setName("Inception");
        movies.add(movie2);

        Movie movie3 = new Movie();
        movie3.setId(3);
        movie3.setName("The Matrix");
        movies.add(movie3);

        Movie movie4 = new Movie();
        movie4.setId(4);
        movie4.setName("Interstellar");
        movies.add(movie4);

        Movie movie5 = new Movie();
        movie5.setId(5);
        movie5.setName("The Dark Knight");
        movies.add(movie5);

        Movie movie6 = new Movie();
        movie6.setId(6);
        movie6.setName("Pulp Fiction");
        movies.add(movie6);

        Movie movie7 = new Movie();
        movie7.setId(7);
        movie7.setName("Fight Club");
        movies.add(movie7);

        Movie movie8 = new Movie();
        movie8.setId(8);
        movie8.setName("Forrest Gump");
        movies.add(movie8);

        Movie movie9 = new Movie();
        movie9.setId(9);
        movie9.setName("The Shawshank Redemption");
        movies.add(movie9);

        Movie movie10 = new Movie();
        movie10.setId(10);
        movie10.setName("Jurassic Park");
        movies.add(movie10);
       for(Movie movie : movies){
           movieIdToMovieMap.put(movie.getId(), movie);
       }
    }
}
