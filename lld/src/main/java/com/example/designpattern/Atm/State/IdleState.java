package com.example.designpattern.Atm.State;

import com.example.designpattern.Atm.ATMSystem;
import com.example.designpattern.Atm.Entities.Card;

public class IdleState extends AtmState {
    @Override 
    public void insertCard(ATMSystem atmSystem, String cardNumber) {
        System.out.println("\nCard has been inserted.");
        Card card = atmSystem.getBankService().getCard(cardNumber);

        if (card == null) {
            exit(atmSystem);
        } else {
            atmSystem.setCurrentCard(card);
            atmSystem.setCurrentState(new HasCardState());
        }
    }
}
