package com.example.designpattern.ObserverDesignPattern.Observer;

import com.example.designpattern.ObserverDesignPattern.Observable.StockObservable;

public class EmailNotificationObserverAlert implements NotificationObserverAlert {

    String emailId;
    StockObservable stockObservable;

    public EmailNotificationObserverAlert(String emailId, StockObservable stockObservable){
        this.emailId = emailId;
        this.stockObservable = stockObservable;
    }

    @Override
    public void update() {
        sendEmail("product is in stock hurry up!!");
    }

    private void sendEmail(String message){
        System.out.println("Mail is sent to: "+emailId);
    }
    
}
