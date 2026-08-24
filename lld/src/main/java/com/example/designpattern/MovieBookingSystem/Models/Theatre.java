package com.example.designpattern.MovieBookingSystem.Models;

import java.util.List;

public class Theatre {
    private final String id;
    private final String name;
    private final City city;
    private final List<Show> shows;
    public Theatre(String id, String name, City city, List<Show> shows) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.shows = shows;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public City getCity() {
        return city;
    }
    public List<Show> getShows() {
        return shows;
    }    
    
}
