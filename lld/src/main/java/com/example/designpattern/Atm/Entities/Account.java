package com.example.designpattern.Atm.Entities;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private final String accountNumber;
    private double balance;
    private Map<String, Card> cards;

    public Account(String accountNum, double balance){
        this.accountNumber = accountNum;
        this.balance = balance;
        cards = new HashMap<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double balance) {
        this.balance += balance;
    }
    
    public boolean withdraw(double amount){
        if(balance>=amount){
            balance -= amount;
            return true;
        }
        return false;
    }

    public Map<String, Card> getCards() {
        return cards;
    }
    
}
