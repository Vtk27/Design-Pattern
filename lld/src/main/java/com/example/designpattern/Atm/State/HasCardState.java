package com.example.designpattern.Atm.State;

import com.example.designpattern.Atm.ATMSystem;
import com.example.designpattern.Atm.Entities.Card;

public class HasCardState extends AtmState{
    
    public HasCardState(){
        System.out.println("Enter pin:");
    }

    @Override
    public void authenticatePin(ATMSystem atmSystem, Card card, String pin){
        System.out.println("Authenticating PIN...");
        boolean isAuthenticated = atmSystem.authenticate(card, pin);;

        if (isAuthenticated) {
            System.out.println("Authentication successful.");
            atmSystem.setCurrentState(new SelectOperationState());
        } else {
            System.out.println("Authentication failed: Incorrect PIN.");
            exit(atmSystem);
        }
    }

    @Override
    public void exit(ATMSystem atmSystem) {
        returnCard();
        atmSystem.setCurrentState(new IdleState());
    }

    @Override
    public void returnCard() {
        System.out.println("Please take your card");
    }

    
}
