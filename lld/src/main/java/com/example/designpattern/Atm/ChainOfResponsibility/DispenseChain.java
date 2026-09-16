package com.example.designpattern.Atm.ChainOfResponsibility;

public interface DispenseChain {
    public void nextChain(DispenseChain nextChain);
    public void dispense(int amount);
    public boolean canDispense(int amount);
}
