package com.example.designpattern.Atm.State;

import com.example.designpattern.Atm.ATMSystem;
import com.example.designpattern.Atm.Entities.Card;

public class CashWithdrawState extends  AtmState{
    public CashWithdrawState(){
        System.out.println("Please enter amount to be withdrawn");
    }

    @Override
    public void cashWithdrawal(ATMSystem atmSystem, Card card, int withdrawAmount) {
        double accountBalance = atmSystem.getBankService().getBalance(card);

        if (withdrawAmount > accountBalance) {
            System.out.println("Error: Insufficient balance.");
            exit(atmSystem);
            return;
        }

        if (!atmSystem.getCashDispenser().canDispense(withdrawAmount)) {
            throw new IllegalStateException("Insufficient cash available in the ATM.");
        }

        atmSystem.getBankService().withdrawMoney(card, withdrawAmount);

        try {
            atmSystem.getCashDispenser().dispense(withdrawAmount);
        } catch (Exception e) {
            atmSystem.getBankService().depositMoney(card, withdrawAmount); // Deposit back if dispensing fails
        }
        exit(atmSystem);
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
