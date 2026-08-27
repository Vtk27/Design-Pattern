package com.example.designpattern.SnakeAndLadderGame.Models;

public class Dice {
    private final int min;
    private final int max;

    public Dice(int min, int max){
        this.min = min;
        this.max = max;
    }

    public int rollDice(){
        return (int)(Math.random() * (max-min+1)+min);
    }
}
