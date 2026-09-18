package com.example.designpattern.VendingMachine.States;

import com.example.designpattern.VendingMachine.VendingMachine;
import com.example.designpattern.VendingMachine.Enums.Coin;

public class DispensingState extends VendingMachineState {

    @Override
    public void dispense(VendingMachine vendingMachine) {
        vendingMachine.setState(new DispensingState());
        vendingMachine.dispenseItem();
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Vending Machine is in dispensing state");
    }

    @Override
    public void refund(VendingMachine vendingMachine) {
        System.out.println("Vending Machine is in dispensing state. Refund not allowed");
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String code) {
        System.out.println("Vending Machine is in dispensing state");
    }
    
}
