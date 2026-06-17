package com.example.designpattern.TicTacToe;

import java.util.Map;
import java.util.Scanner;

import com.example.designpattern.TicTacToe.Interface.GameStatusEnum;

public class Game {
    TTTPlayer P1, P2;
    Board board;
    Map<TTTPlayer, TTTPlayer> mp;
    int moves;
    public Game(TTTPlayer p1, TTTPlayer p2, Board board){
        this.P1 = p1;
        this.P2 = p2;
        this.board = board;
        mp = Map.of(P1, P2, P2, P1);
        this.moves = 0;
    }

    public GameStatusEnum gameDriver(int cellNo, TTTPlayer P){
        if(cellNo < 0 || cellNo >= board.getCols()*board.getRows()) {
            return GameStatusEnum.INVALID;
        }
        if(!board.fillPlayerSymbol(cellNo, P)){
            return GameStatusEnum.INVALID;
        }
        int gameStatus = board.isGameCompleted(P.getSymbol());
        if(gameStatus==2){
            return GameStatusEnum.WON;
        }
        moves++;
        if(moves == board.getCols()*board.getRows()) return GameStatusEnum.DRAWN;
        return GameStatusEnum.IN_PROGRESS;
    }

    public void gameController(){
        TTTPlayer P;
        System.out.println("Choose Player 1 or 2 to start the game");

        Scanner sc = new Scanner(System.in);
        int playerNo = sc.nextInt();
        
        if(playerNo == 1) P = P1;
        else P = P2;
        while(true){
            board.printEmptyCellNo();
            System.out.println("Player: "+P.getName()+" Please select the cell number you want to fill!!");
            int cellNo = sc.nextInt();
            GameStatusEnum state = gameDriver(cellNo, P);
            
            if(GameStatusEnum.DRAWN.equals(state)){
                System.out.println("All Cells are filled. Game Drawn");
                break;
            }
            else if(GameStatusEnum.WON.equals(state)){
                System.out.println(P.getName()+" Won the Game!");
                break;
            }
            else if(GameStatusEnum.IN_PROGRESS.equals(state)) P = mp.get(P);
            else{
                System.out.println("Choosen cell is invalid. Please choose empty cell number");
            }
        }
        board.printEmptyCellNo();
        sc.close();
    }
}
