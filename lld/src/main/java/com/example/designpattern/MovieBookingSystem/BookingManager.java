package com.example.designpattern.MovieBookingSystem;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.designpattern.MovieBookingSystem.Enums.PaymentStatus;
import com.example.designpattern.MovieBookingSystem.Models.Booking;
import com.example.designpattern.MovieBookingSystem.Models.Payment;
import com.example.designpattern.MovieBookingSystem.Models.Seat;
import com.example.designpattern.MovieBookingSystem.Models.Show;

public class BookingManager {
    private final SeatLockingManager seatLockingManager;

    public BookingManager(SeatLockingManager seatLockingManager){
        this.seatLockingManager = seatLockingManager;
    }

    public Optional<Booking> createBooking(Show show, List<Seat> seats, String userId){
        if(!seatLockingManager.lockSeats(show, seats, userId)){
            System.out.println("Seats are not available for booking");
            return Optional.empty();
        }

        Payment payment = new Payment(userId, PaymentStatus.PENDING, userId);

        double totalAmount = payment.calculateAmount(seats);

        PaymentStatus paymentStatus = payment.makePayment(totalAmount);

        if(PaymentStatus.SUCCESS.equals(paymentStatus)){
            Booking booking = new Booking(UUID.randomUUID().toString(), payment, seats, userId, show, totalAmount);

            booking.confirmBooking();
            seatLockingManager.unlockSeats(seats, show, userId);
            return Optional.of(booking);
        }else{
            System.out.println("Booking failed pls try again");
            return Optional.empty();
        }
    }
}
