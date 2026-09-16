package com.example.designpattern.Atm.State;

import com.example.designpattern.Atm.ATMSystem;
import com.example.designpattern.Atm.Entities.Card;

public class CheckBalanceState extends AtmState {
    public CheckBalanceState(){
        System.out.println("Checking balance..");
    }

    @Override
    public void displayBalance(ATMSystem ATMSystem, Card card) {
        System.out.println("Your balance is->"+ATMSystem.getBankService().getBalance(card));
        exit(ATMSystem);
    }

    @Override
    public void exit(ATMSystem ATMSystem) {
        returnCard();
        ATMSystem.setCurrentState(new IdleState());
        System.out.println("Exit completed");
    }

    @Override
    public void returnCard() {
        System.out.println("Please take your card");
    }

}
