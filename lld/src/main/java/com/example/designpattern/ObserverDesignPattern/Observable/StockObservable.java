package com.example.designpattern.ObserverDesignPattern.Observable;

import com.example.designpattern.ObserverDesignPattern.Observer.NotificationObserverAlert;

public interface StockObservable {
    public void add(NotificationObserverAlert notificationObserverAlert);
    public void remove(NotificationObserverAlert notificationObserverAlert);
    public void notifySubscribers();
    public void setStockCount(int newStockAdded);
    public int getStockCount();
}
