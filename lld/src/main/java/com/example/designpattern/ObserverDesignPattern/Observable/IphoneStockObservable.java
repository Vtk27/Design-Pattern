package com.example.designpattern.ObserverDesignPattern.Observable;

import java.util.ArrayList;
import java.util.List;

import com.example.designpattern.ObserverDesignPattern.Observer.NotificationObserverAlert;

public class IphoneStockObservable implements StockObservable {

    private int stockCount = 0;
    private List<NotificationObserverAlert> observerList = new ArrayList<>();

    @Override
    public void add(NotificationObserverAlert notificationObserverAlert) {
        observerList.add(notificationObserverAlert);
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }

    @Override
    public void notifySubscribers() {
        for(NotificationObserverAlert obs: observerList){
            obs.update();
        }
    }

    @Override
    public void remove(NotificationObserverAlert notificationObserverAlert) {
        observerList.remove(notificationObserverAlert);        
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(stockCount == 0){
            notifySubscribers();
        }        
        stockCount = newStockAdded;
    }
    
}
