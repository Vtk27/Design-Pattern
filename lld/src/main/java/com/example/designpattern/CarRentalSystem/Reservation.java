package com.example.designpattern.CarRentalSystem;

import java.sql.Date;

import com.example.designpattern.CarRentalSystem.Product.Vehicle;

public class Reservation {
    int reservationId;
    User user;
    Vehicle vehicle;
    Date bookingDate;
    Date dateBookedFrom;
    Date dateBookedTo;
    Long fromTimeStamp;
    Long toTimeStamp; 
    Location pickUpLocation;
    Location dropLocation;
    ReservationType reservationType;
    ReservationStatus reservationStatus;

    Reservation(User user, Vehicle vehicle, ReservationType reservationType, ReservationStatus reservationStatus){
        this.user = user;
        this.vehicle = vehicle;
        this.reservationType = reservationType;
        this.reservationStatus = reservationStatus;
    }
    
}
