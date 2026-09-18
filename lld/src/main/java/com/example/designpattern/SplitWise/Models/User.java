package com.example.designpattern.SplitWise.Models;

import java.util.UUID;

public class User {
    private final String id;
    private final String name;
    private final BalanceSheet balanceSheet;

    public User(String name){
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.balanceSheet = new BalanceSheet(this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }
    
}
