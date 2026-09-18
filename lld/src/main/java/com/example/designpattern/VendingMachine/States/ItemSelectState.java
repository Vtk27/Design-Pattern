package com.example.designpattern.VendingMachine.States;

import com.example.designpattern.VendingMachine.VendingMachine;
import com.example.designpattern.VendingMachine.Enums.Coin;

public class ItemSelectState extends VendingMachineState {

    public ItemSelectState(){
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Please select items before inserting coins");
    }


    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("Please insert sufficient money.");
    }

    @Override
    public void refund(VendingMachine vendingMachine) {
        vendingMachine.reset();
        vendingMachine.setState(new IdleState());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String code) {
        if(!vendingMachine.getInventory().isAvailable(code)){
            System.out.println("Item not available.");
            return;
        }
        vendingMachine.setSelectedItemCode(code);
        vendingMachine.setState(new HasMoneyState());
        System.out.println("Item selected: " + code);
    }
    
}
