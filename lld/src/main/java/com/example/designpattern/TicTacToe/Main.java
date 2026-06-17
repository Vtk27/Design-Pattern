package com.example.designpattern.TicTacToe;

import com.example.designpattern.TicTacToe.Interface.SymbolEnum;

public class Main {
    public static void main(String[] args) {
        TTTPlayer p1 = new TTTPlayer("Java", SymbolEnum.O);
        TTTPlayer p2 = new TTTPlayer("Python", SymbolEnum.X);
        
        Board board = new Board(3, 3);
        Game game = new Game(p1, p2, board);
        game.gameController();
    }
}
