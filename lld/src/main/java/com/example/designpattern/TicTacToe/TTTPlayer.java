package com.example.designpattern.TicTacToe;

import com.example.designpattern.TicTacToe.Interface.Player;
import com.example.designpattern.TicTacToe.Interface.SymbolEnum;

public class TTTPlayer implements Player {
    private String name;
    private SymbolEnum symbol;

    TTTPlayer(String name, SymbolEnum symbol){
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String getName(){
        return name;
    }

    public SymbolEnum getSymbol(){
        return symbol;
    }
}
