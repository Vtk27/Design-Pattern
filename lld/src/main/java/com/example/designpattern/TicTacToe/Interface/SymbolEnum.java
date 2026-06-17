package com.example.designpattern.TicTacToe.Interface;

public enum SymbolEnum {
    X("X"),
    O("O");

    String symbol;
    private SymbolEnum(String symbol){
        this.symbol = symbol;
    }

    public String getSymbol(){
        return symbol;
    }
}
