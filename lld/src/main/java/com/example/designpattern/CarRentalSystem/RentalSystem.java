package com.example.designpattern.CarRentalSystem;

import java.util.List;

public class RentalSystem {
    List<Store> storeList;
    List<User> userList;

    RentalSystem(List<Store> stores, List<User> users){
        this.storeList = stores;
        this.userList = users;
    }

    public Store getNearByStore(Location location){
        //sort with some alogrithm
        return storeList.get(0);
    }
}
