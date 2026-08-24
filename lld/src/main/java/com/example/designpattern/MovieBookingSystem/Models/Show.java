package com.example.designpattern.MovieBookingSystem.Models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Show {
    private final String id;
    private final Screen screen;
    private Movie movie;
    private LocalDateTime startTime;
    private final List<Seat> seats;
    public Show(String id, Screen screen, Movie movie, LocalDateTime startTime) {
        this.id = id;
        this.screen = screen;
        this.movie = movie;
        this.startTime = startTime;
        seats = new ArrayList<>();
    }
    public String getId() {
        return id;
    }
    public Screen getScreen() {
        return screen;
    }
    public Movie getMovie() {
        return movie;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public List<Seat> getSeats(){
        return seats;
    }
    public void addSeat(Seat seat){
        seats.add(seat);
    }
}
