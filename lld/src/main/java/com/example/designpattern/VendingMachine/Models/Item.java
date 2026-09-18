package com.example.designpattern.VendingMachine.Models;

public class Item {
    private final String code;
    private final String name;
    private final int cost;

    public Item(String code, String name, int cost){
        this.code = code;
        this.name = name;
        this.cost = cost;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
    
}
