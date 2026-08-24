package com.example.designpattern.MovieBookingSystem.Models;

import java.util.List;

import com.example.designpattern.MovieBookingSystem.Enums.SeatStatus;

public class Booking {
    private final String id;
    private final Payment payment;
    private final List<Seat> bookedSeats;
    private final String userName;
    private final Show show;
    private final double totalAmount;


    public Booking(String id, Payment payment, List<Seat> bookedSeats, String userName, Show show, double totalAmount) {
        this.id = id;
        this.payment = payment;
        this.bookedSeats = bookedSeats;
        this.userName = userName;
        this.show = show;
        this.totalAmount = totalAmount;
    }

    public void confirmBooking(){
        for(Seat seat:bookedSeats){
           seat.setSeatStatus(SeatStatus.BOOKED); 
        }
    }

    public String getId() {
        return id;
    }

    public Payment getPayment() {
        return payment;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public String getUserName() {
        return userName;
    }

    public Show getShow() {
        return show;
    }
    
    public double getTotalAmount() {
        return totalAmount;
    }
}
