package com.example.designpattern.VendingMachine;

import com.example.designpattern.VendingMachine.Enums.Coin;

public class VendingMachineDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = VendingMachine.getInstance();

        vendingMachine.addItem("A1", "Coke", 25, 3);
        vendingMachine.addItem("A2", "Pepsi", 25, 2);
        vendingMachine.addItem("B1", "Water", 10, 5);
        
        //click on select item button
        System.out.println("\n--- Step 1: Click on Select Item option ---");
        vendingMachine.clickOnSelectItem();
        
        // Select a product
        System.out.println("\n--- Step 2: Select an item ---");
        vendingMachine.selectItem("A1");

         // Insert coins
        System.out.println("\n--- Step 3: Insert coins ---");
        vendingMachine.insertCoin(Coin.DIME); // 10
        vendingMachine.insertCoin(Coin.DIME); // 10
        vendingMachine.insertCoin(Coin.NICKEL); // 5

        // Dispense the product
        System.out.println("\n--- Step 4: Dispense item ---");
        vendingMachine.dispense(); // Should dispense Coke

        // Click on select item
        System.out.println("\n--- Step 5: Click on Select Item option ---");
        vendingMachine.clickOnSelectItem();

        // Select another item
        System.out.println("\n--- Step 6: Select another item ---");
        vendingMachine.selectItem("B1");

        // Insert more amount
        System.out.println("\n--- Step 7: Insert more than needed ---");
        vendingMachine.insertCoin(Coin.QUARTER); // 25

        // Try to dispense the product
        System.out.println("\n--- Step 8: Dispense and return change ---");
        vendingMachine.dispense();
    }    
}
