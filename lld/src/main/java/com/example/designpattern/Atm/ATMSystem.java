package com.example.designpattern.Atm;

import com.example.designpattern.Atm.ChainOfResponsibility.DispenseChain;
import com.example.designpattern.Atm.ChainOfResponsibility.NoteDispenser100;
import com.example.designpattern.Atm.ChainOfResponsibility.NoteDispenser20;
import com.example.designpattern.Atm.ChainOfResponsibility.NoteDispenser50;
import com.example.designpattern.Atm.Entities.BankService;
import com.example.designpattern.Atm.Entities.Card;
import com.example.designpattern.Atm.Entities.CashDispenser;
import com.example.designpattern.Atm.Enums.OperationType;
import com.example.designpattern.Atm.State.AtmState;
import com.example.designpattern.Atm.State.IdleState;

public class ATMSystem {
    private static ATMSystem INSTANCE;
    private final BankService bankService;
    private final CashDispenser cashDispenser;
    public CashDispenser getCashDispenser() {
        return cashDispenser;
    }
    private Card currentCard;
    private AtmState currentState;

    private ATMSystem() {
        this.currentState = new IdleState();
        this.bankService = new BankService();

        // Setup the dispenser chain
        DispenseChain c1 = new NoteDispenser100(10); // 10 x $100 notes
        DispenseChain c2 = new NoteDispenser50(20); // 20 x $50 notes
        DispenseChain c3 = new NoteDispenser20(30); // 30 x $20 notes
        c1.nextChain(c2);
        c2.nextChain(c3);
        this.cashDispenser = new CashDispenser(c1);
    }

    public static ATMSystem getInstance(){
        if(INSTANCE==null){
            INSTANCE = new ATMSystem();
        }
        return INSTANCE;
    }

    public void setCurrentState(AtmState currentState) {
        this.currentState = currentState;
    }

    public void setCurrentCard(Card card) { this.currentCard = card; }

    public boolean authenticate(Card card, String pin){
        return bankService.authenticate(card, pin);
    }

    public BankService getBankService() {
        return bankService;
    }

    public void insertCard(String card) {
        currentState.insertCard(this, card);
    }

    public void enterPin(String pin) {
        currentState.authenticatePin(this, this.currentCard, pin);
    }

    public void selectOperation(OperationType op) { currentState.selectOperation(this, currentCard, op); }

    public void withdrawCash(int amount){
        currentState.cashWithdrawal(this, currentCard, amount);
    }

    public void depositCash(int amount){
        currentState.depositCash(this, currentCard, amount);
    }

    public void checkBalance(){
        currentState.displayBalance(this, currentCard);
    }
}
