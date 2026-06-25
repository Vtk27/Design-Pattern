package com.example.designpattern.CarRentalSystem;

import java.util.Date;

public class Payment {

    int paymentId;
    double amountPaid;
    Date dateOfPayment;
    PaymentMode paymentMode;
    
    Payment(Bill bill, PaymentMode paymentMode){
        amountPaid = bill.CalculateBill();
        this.paymentMode = paymentMode;
    }

    public void doPayment(){
        
    }
}
