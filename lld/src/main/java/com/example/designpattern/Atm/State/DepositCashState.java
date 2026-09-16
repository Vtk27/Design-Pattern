package com.example.designpattern.Atm.State;

import com.example.designpattern.Atm.ATMSystem;
import com.example.designpattern.Atm.Entities.Card;

public class DepositCashState extends AtmState{
    public DepositCashState(){
        System.out.println("Please deposit the cash below..");
    }

    @Override
    public void depositCash(ATMSystem ATMSystem, Card card, int amountDeposit) {
        ATMSystem.getBankService().depositMoney(card, amountDeposit);
        System.out.println("Amount is credited to your bank account");
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
