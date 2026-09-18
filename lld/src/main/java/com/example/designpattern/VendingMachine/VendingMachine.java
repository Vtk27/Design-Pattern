package com.example.designpattern.VendingMachine;

import com.example.designpattern.VendingMachine.Enums.Coin;
import com.example.designpattern.VendingMachine.Models.Inventory;
import com.example.designpattern.VendingMachine.Models.Item;
import com.example.designpattern.VendingMachine.States.IdleState;
import com.example.designpattern.VendingMachine.States.VendingMachineState;

public class VendingMachine {
    private static VendingMachine Instance;
    private final Inventory inventory;
    private VendingMachineState vendingMachineState;
    private int balance;
    private String selectedItemCode;

    public VendingMachine(){
        vendingMachineState = new IdleState();
        balance = 0;
        inventory = new Inventory();
    }

    public static VendingMachine getInstance(){
        if(Instance==null) Instance = new VendingMachine();
        return Instance;
    }

    public Item addItem(String code, String name, int price, int quantity) {
        Item item = new Item(code, name, price);
        inventory.addItem(code, item, quantity);
        return item;
    }

    public Item getSelectedItemCode() {
        return inventory.getItem(selectedItemCode);
    }

    public void setSelectedItemCode(String code) {
        this.selectedItemCode = code;
    }

    public void setState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() { return inventory; }
    public int getBalance() { return balance; }
    
    public void addBalance(int coinVal){
        balance += coinVal;
    }

    public void reset() {
        selectedItemCode = null;
        balance = 0;
    }

    public void insertCoin(Coin coin) {
        vendingMachineState.insertCoin(this, coin);
    }

    public void clickOnSelectItem() {
        vendingMachineState.clickOnSelectItem(this);
    }

    public void selectItem(String code) {
        vendingMachineState.selectItem(this, code);
    }

    public void dispense(){
        vendingMachineState.dispense(this);
    }

    public void dispenseItem() {
        Item item = inventory.getItem(selectedItemCode);
        if (balance >= item.getCost()) {
            inventory.reduceStock(selectedItemCode);
            balance -= item.getCost();
            System.out.println("Dispensed: " + item.getName());
            if (balance > 0) {
                System.out.println("Returning change: " + balance);
            }
        }
        reset();
        setState(new IdleState());
    }

    public void refundBalance() {
        System.out.println("Refunding: " + balance);
        balance = 0;
    }
}
