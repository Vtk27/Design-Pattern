package com.example.designpattern.Atm.Entities;

import com.example.designpattern.Atm.ChainOfResponsibility.DispenseChain;

public class CashDispenser {
    private final DispenseChain dispenseChain;
    public CashDispenser(DispenseChain dispenseChain){
        this.dispenseChain = dispenseChain;
    }

    public void dispense(int amount){
        this.dispenseChain.dispense(amount);
    }
    public boolean canDispense(int amount){
        if(amount % 20 == 0){
            return false;
        }
        return dispenseChain.canDispense(amount);
    }
}
