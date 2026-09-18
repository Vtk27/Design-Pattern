package com.example.designpattern.VendingMachine.States;

import com.example.designpattern.VendingMachine.VendingMachine;
import com.example.designpattern.VendingMachine.Enums.Coin;

public class IdleState extends VendingMachineState {

    public IdleState(){
        System.out.println("Currently Vending machine is in IdleState");
    }

    @Override 
    public void clickOnSelectItem(VendingMachine vendingMachine){
        System.out.println("User clicked on select item button");
        vendingMachine.setState(new ItemSelectState());
    }

    @Override
    public void selectItem(VendingMachine vendingMachine, String code) {
        System.out.println("Click on select item button!");
    }
    
    @Override
    public void dispense(VendingMachine vendingMachine) {
        System.out.println("No item selected.");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) {
        System.out.println("Please select an item before inserting money.");
    }

    @Override
    public void refund(VendingMachine vendingMachine) {
         System.out.println("No money to refund.");
    }
    
}
