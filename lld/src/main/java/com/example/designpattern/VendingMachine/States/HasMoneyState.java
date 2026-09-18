package com.example.designpattern.VendingMachine.States;

import com.example.designpattern.VendingMachine.VendingMachine;
import com.example.designpattern.VendingMachine.Enums.Coin;

public class HasMoneyState extends VendingMachineState {

    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("please add coins to dispense item");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        vendingMachine.addBalance(coin.getVal());
        System.out.println("Coin Inserted: " + coin.getVal());
        int price = vendingMachine.getSelectedItemCode().getCost();
        if (vendingMachine.getBalance() >= price) {
            System.out.println("Sufficient money received.");
            vendingMachine.setState(new DispensingState());
        }
    }

    @Override
    public void refund(VendingMachine vendingMachine) {
        vendingMachine.refundBalance();
        vendingMachine.reset();
        vendingMachine.setState(new IdleState());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String code) {
        System.out.println("Item already selected.");
    }
    
}
