package com.example.designpattern.Atm.State;

import com.example.designpattern.Atm.ATMSystem;
import com.example.designpattern.Atm.Entities.Card;
import com.example.designpattern.Atm.Enums.OperationType;

public abstract class AtmState {
    public void insertCard(ATMSystem ATMSystem, String cardNumber) {
        System.out.println("OOPS!! Something went wrong");
    }

    public void authenticatePin(ATMSystem ATMSystem, Card card, String pin){
        System.out.println("OOPS!! Something went wrong");
    }

    public void selectOperation(ATMSystem ATMSystem, Card card, OperationType txnType){
        System.out.println("OOPS!! Something went wrong");
    }

    public void cashWithdrawal(ATMSystem ATMSystem, Card card, int withdrawAmount){
        System.out.println("OOPS!! Something went wrong");
    }

    public void displayBalance(ATMSystem ATMSystem, Card card){
        System.out.println("OOPS!! Something went wrong");
    }

    public void depositCash(ATMSystem ATMSystem, Card card, int amountDeposit){
        System.out.println("OOPS!! Something went wrong");
    }

    public void returnCard(){
        System.out.println("OOPS!! Something went wrong");
    }

    public void exit(ATMSystem ATMSystem){
        System.out.println("OOPS!! Something went wrong");
    }
}
