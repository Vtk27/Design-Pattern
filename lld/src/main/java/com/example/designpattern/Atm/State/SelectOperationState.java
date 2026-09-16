package com.example.designpattern.Atm.State;

import com.example.designpattern.Atm.ATMSystem;
import com.example.designpattern.Atm.Entities.Card;
import com.example.designpattern.Atm.Enums.OperationType;

public class SelectOperationState extends AtmState{

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

    @Override
    public void selectOperation(ATMSystem atmSystem, Card card, OperationType txnType) {
        switch(txnType){
            case CASH_WITHDRAWAL:
                atmSystem.setCurrentState(new CashWithdrawState());
                break;
            case BALANCE_CHECK:
                atmSystem.setCurrentState(new CheckBalanceState());
                break;
            case DEPOSIT_CASH:
                atmSystem.setCurrentState(new DepositCashState());
                break;
            default:
                System.out.println("Invalid option is select");
                exit(atmSystem);
        }
    }
    
}
