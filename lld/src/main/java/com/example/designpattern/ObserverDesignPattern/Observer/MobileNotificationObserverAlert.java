package com.example.designpattern.ObserverDesignPattern.Observer;

import com.example.designpattern.ObserverDesignPattern.Observable.StockObservable;

public class MobileNotificationObserverAlert implements NotificationObserverAlert {

    public String userName;
     StockObservable stockObservable;

    public MobileNotificationObserverAlert(String userName, StockObservable stockObservable){
        this.userName = userName;
        this.stockObservable = stockObservable;
    }
    @Override
    public void update() {
        sendMsgOnMobile("Product is in stock hurry up!!");
    }

     public void sendMsgOnMobile(String msg){
        System.out.println("msg sent to : "+userName);
    }
    
}
