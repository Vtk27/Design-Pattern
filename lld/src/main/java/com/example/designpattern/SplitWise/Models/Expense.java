package com.example.designpattern.SplitWise.Models;

import java.util.List;
import java.util.UUID;

import com.example.designpattern.SplitWise.Stratergy.SplitStratergy;

public class Expense {
    private final String id;
    private final String description;
    private final double amount;
    private final User paidBy;
    private final List<Split> splits;
    private final SplitStratergy splitStratergy;
    
    private Expense(ExpenseBuilder builder){
        this.id = UUID.randomUUID().toString();
        this.description = builder.description;
        this.amount = builder.amount;
        this.paidBy = builder.paidBy;   
        this.splits = builder.splitStratergy.calculateSplits(amount, builder.participants, builder.splitsValues);
        this.splitStratergy = builder.splitStratergy;
    }
    
    public static class ExpenseBuilder{
        private String description;
        private double amount;
        private User paidBy;
        private List<Double> splitsValues;
        private List<User> participants;
        private SplitStratergy splitStratergy;

        public ExpenseBuilder setDescription(String descString){
            this.description = descString;
            return this;
        }
         public ExpenseBuilder setAmount(double amount) { this.amount = amount; return this; }
        public ExpenseBuilder setPaidBy(User paidBy) { this.paidBy = paidBy; return this; }
        public ExpenseBuilder setSplitStrategy(SplitStratergy splitStrategy) { this.splitStratergy = splitStrategy; return this; }
        public ExpenseBuilder setSplitsValue(List<Double> splitValues){this.splitsValues = splitValues; return this;}
        public ExpenseBuilder setParticipants(List<User> participants) { this.participants = participants; return this; }

        public Expense build(){
            if (splitStratergy == null) {
                throw new IllegalStateException("Split strategy is required.");
            }
            return new Expense(this);
        }
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public SplitStratergy getSplitStratergy() {
        return splitStratergy;
    }
}
