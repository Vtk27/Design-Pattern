package com.example.designpattern.MovieBookingSystem.Models;

public class Movie {
    private final String id;
    private final String name;
    private final int duration;

    public Movie(String id, String name, int time){
        this.id = id;
        this.name = name;
        this.duration = time;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

}
