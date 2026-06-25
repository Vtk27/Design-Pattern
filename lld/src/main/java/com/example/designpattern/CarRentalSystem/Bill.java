package com.example.designpattern.CarRentalSystem;

public class Bill {
    Reservation reservation;
    boolean isBillPaid;
    
    Bill(Reservation reservation){
        this.reservation = reservation;
        isBillPaid = false;
    }

    public double CalculateBill(){
        return 100;
    }
}
