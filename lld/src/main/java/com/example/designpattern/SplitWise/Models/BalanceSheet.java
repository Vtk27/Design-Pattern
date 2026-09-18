package com.example.designpattern.SplitWise.Models;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceSheet {
    private final User owner;
    private final Map<User, Double> balances;

    public BalanceSheet(User owner){
        this.owner = owner;
        balances = new ConcurrentHashMap<>();
    }

    public User getOwner() {
        return owner;
    }

    public Map<User, Double> getBalance() {
        return balances;
    }
    
    public synchronized void adjustBalance(User splitUser, double amount){
        balances.put(splitUser, balances.getOrDefault(splitUser, 0d)+amount);
        if(balances.get(splitUser)==0.0) balances.remove(splitUser);
    }

    public void showBalances() {
        System.out.println("--- Balance Sheet for " + owner.getName() + " ---");
        if (balances.isEmpty()) {
            System.out.println("All settled up!");
            return;
        }

        double totalOwedToMe = 0;
        double totalIOwe = 0;

        for (Map.Entry<User, Double> entry : balances.entrySet()) {
            User otherUser = entry.getKey();
            double amount = entry.getValue();

            if (amount > 0) {
                System.out.println(otherUser.getName() + " owes " + owner.getName() + " $" + String.format("%.2f", amount));
                totalOwedToMe += amount;
            } else {
                System.out.println(owner.getName() + " owes " + otherUser.getName() + " $" + String.format("%.2f", -amount));
                totalIOwe += (-amount);
            }
        }
        System.out.println("Total Owed to " + owner.getName() + ": $" + String.format("%.2f", totalOwedToMe));
        System.out.println("Total " + owner.getName() + " Owes: $" + String.format("%.2f", totalIOwe));
        System.out.println("---------------------------------");
    }
}
