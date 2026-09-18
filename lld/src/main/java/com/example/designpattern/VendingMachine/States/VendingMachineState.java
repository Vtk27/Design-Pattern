package com.example.designpattern.VendingMachine.States;

import com.example.designpattern.VendingMachine.VendingMachine;
import com.example.designpattern.VendingMachine.Enums.Coin;

public abstract class VendingMachineState {
    public void clickOnSelectItem(VendingMachine vendingMachine){
        System.out.println("vending machine is idle state! click on select Item");
    }
    public abstract void insertCoin(VendingMachine vendingMachine, Coin coin);
    public abstract void selectItem(VendingMachine vendingMachine, String code);
    public abstract void dispense(VendingMachine vendingMachine);
    public abstract void refund(VendingMachine vendingMachine);
}
