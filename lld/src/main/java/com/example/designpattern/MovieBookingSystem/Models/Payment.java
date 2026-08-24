package com.example.designpattern.MovieBookingSystem.Models;

import java.util.List;

import com.example.designpattern.MovieBookingSystem.Enums.PaymentStatus;

public class Payment {
    private final String id;
    private double amount;
    private PaymentStatus paymentStatus;
    private final String transactionId;

    public Payment(String id, PaymentStatus paymentStatus, String transactionId) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.transactionId = transactionId;
    }

    public PaymentStatus getPaymentStatus(){return paymentStatus;}
    public void setPaymentStatus(PaymentStatus ps){
        paymentStatus = ps;
    }

    public PaymentStatus makePayment(double amount){
        System.out.println("Payment confirmed! Total amount paid->"+amount);
        setPaymentStatus(PaymentStatus.SUCCESS);
        return paymentStatus;
    }

    public double calculateAmount(List<Seat> seats){
        amount = seats.stream().mapToDouble(p->p.getCost()).sum();
        return amount;
    }
}
