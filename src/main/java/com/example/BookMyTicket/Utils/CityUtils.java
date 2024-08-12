package com.example.BookMyTicket.Utils;

import com.example.BookMyTicket.entities.City;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class CityUtils {
    public static List<City> cities = new ArrayList<>();
    static {
        City city1 = new City();
        city1.setId(1);
        city1.setCityName("bangalore");
        city1.setState("karnataka");
        city1.setCountry("India");
        cities.add(city1);
        City city2 = new City();
        city2.setId(2);
        city2.setCityName("Mumbai");
        city2.setState("Maharashtra");
        city2.setCountry("India");
        cities.add(city2);

        City city3 = new City();
        city3.setId(3);
        city3.setCityName("Delhi");
        city3.setState("Delhi");
        city3.setCountry("India");
        cities.add(city3);

        City city4 = new City();
        city4.setId(4);
        city4.setCityName("Kolkata");
        city4.setState("West Bengal");
        city4.setCountry("India");
        cities.add(city4);

        City city5 = new City();
        city5.setId(5);
        city5.setCityName("Chennai");
        city5.setState("Tamil Nadu");
        city5.setCountry("India");
        cities.add(city5);

        City city6 = new City();
        city6.setId(6);
        city6.setCityName("Hyderabad");
        city6.setState("Telangana");
        city6.setCountry("India");
        cities.add(city6);

        City city7 = new City();
        city7.setId(7);
        city7.setCityName("Pune");
        city7.setState("Maharashtra");
        city7.setCountry("India");
        cities.add(city7);

        City city8 = new City();
        city8.setId(8);
        city8.setCityName("Ahmedabad");
        city8.setState("Gujarat");
        city8.setCountry("India");
        cities.add(city8);

        City city9 = new City();
        city9.setId(9);
        city9.setCityName("Jaipur");
        city9.setState("Rajasthan");
        city9.setCountry("India");
        cities.add(city9);

        City city10 = new City();
        city10.setId(10);
        city10.setCityName("Lucknow");
        city10.setState("Uttar Pradesh");
        city10.setCountry("India");
        cities.add(city10);
    }
}
