package com.example.designpattern.SnakeAndLadderGame;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.example.designpattern.SnakeAndLadderGame.Enums.GameStatus;
import com.example.designpattern.SnakeAndLadderGame.Models.Board;
import com.example.designpattern.SnakeAndLadderGame.Models.Dice;

import com.example.designpattern.SnakeAndLadderGame.Models.Player;

public class Game {
    private final Board board;
    private final Dice dice;
    private final Queue<Player> players;
    private GameStatus gameStatus;
    private Player winner;

    Game(Builder builder){
        this.board = builder.board;
        this.dice = builder.dice;
        this.players = builder.players;
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public void play(){
        if(players.size()<2){
            System.out.println("cannot be played with less than 2 members");
            return;
        }
        gameStatus = GameStatus.RUNNING;
        System.out.println("Game started!");
        while(gameStatus == GameStatus.RUNNING){
            Player current = players.poll();
            takeTurn(current);
            players.add(current);
        }

        System.out.println("Game Finished!");
        if (winner != null) {
            System.out.printf("The winner is %s!\n", winner.getName());
        }
    }

    private void takeTurn(Player player){
        int roll = dice.rollDice();
        System.out.printf("\n%s's turn. Rolled a %d.\n", player.getName(), roll);

        int currentPosition = player.getPosition();
        int nextPosition = currentPosition + roll;

        if (nextPosition > board.getSize()) {
            System.out.printf("Oops, %s needs to land exactly on %d. Turn skipped.\n", player.getName(), board.getSize());
            return;
        }
 
        int finalPosition = board.getFinalPosition(nextPosition);

        if (finalPosition > nextPosition) { // Ladder
            System.out.printf("Wow! %s found a ladder 🪜 at %d and climbed to %d.\n", player.getName(), nextPosition, finalPosition);
        } else if (finalPosition < nextPosition) { // Snake
            System.out.printf("Oh no! %s was bitten by a snake 🐍 at %d and slid down to %d.\n", player.getName(), nextPosition, finalPosition);
        } else {
            System.out.printf("%s moved from %d to %d.\n", player.getName(), currentPosition, finalPosition);
        }

        if (finalPosition == board.getSize()) {
            player.setPosition(nextPosition);
            this.winner = player;
            this.gameStatus = GameStatus.FINISHED;
            System.out.printf("Hooray! %s reached the final square %d and won!\n", player.getName(), board.getSize());
            return;
        }
        player.setPosition(finalPosition);
        if (roll == 6) {
            System.out.printf("%s rolled a 6 and gets another turn!\n", player.getName());
            takeTurn(player);
        }
    }

    public static class Builder{
        private Board board;
        private Queue<Player> players;
        private Dice dice;
        public Builder setBoard(Board board){
            this.board = board;
            return this;
        }

        public Builder setDice(Dice dice){
            this.dice = dice;
            return this;
        }

        public Builder setPlayer(List<Player> players){
            this.players = new LinkedList<>();
            players.forEach(player -> this.players.add(player));
            return this;
        }

        public Game Build(){
            if(board==null || players == null || dice == null){
                throw new IllegalArgumentException("Board, Player and Dice should be intiatied to begin the game");
            }
            return new Game(this);
        }

    }
}
