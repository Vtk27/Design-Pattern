package com.example.designpattern.SplitWise.Models;

public class Transaction {
    private final User fromUser;
    private final User toUser;
    private double amount;

    public Transaction(User fromUser, User toUser, double amount){
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
    }

    @Override 
    public String toString() {
        return fromUser.getName() + " should pay " + toUser.getName() + " $" + String.format("%.2f", amount);
    }
}
