package com.example.designpattern.MovieBookingSystem.Models;

import com.example.designpattern.MovieBookingSystem.Enums.SeatStatus;

public class Seat {
    private final String id;
    private final int pos;
    private final int cost;
    private SeatStatus seatStatus;

    public Seat(String id, int pos, int cost) {
        this.id = id;
        this.pos = pos;
        this.cost = cost;
        this.seatStatus = SeatStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public int getPos() {
        return pos;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }    

    public int getCost(){return cost;}
}
