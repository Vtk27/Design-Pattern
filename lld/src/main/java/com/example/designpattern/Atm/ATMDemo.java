package com.example.designpattern.Atm;

import com.example.designpattern.Atm.Enums.OperationType;

public class ATMDemo {
    public static void main(String[] args) {
         ATMSystem atmSystem = ATMSystem.getInstance();

        // Perform Check Balance operation
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("1234");
        atmSystem.selectOperation(OperationType.BALANCE_CHECK); // $1000
        atmSystem.checkBalance();

         // Perform Withdraw Cash operation
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("1234");
        atmSystem.selectOperation(OperationType.CASH_WITHDRAWAL);
        atmSystem.withdrawCash(570);

        // Perform Deposit Cash operation
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("1234");
        atmSystem.selectOperation(OperationType.DEPOSIT_CASH);
        atmSystem.depositCash(200);

        // Perform Check Balance operation
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("1234");
        atmSystem.selectOperation(OperationType.BALANCE_CHECK); // $1000
        atmSystem.checkBalance();

        // Perform Withdraw Cash more than balance
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("1234");
        atmSystem.selectOperation(OperationType.CASH_WITHDRAWAL); // Insufficient balance
        atmSystem.withdrawCash(700);

        // Insert Incorrect PIN
        atmSystem.insertCard("1234-5678-9012-3456");
        atmSystem.enterPin("3425");

    }
    
}
