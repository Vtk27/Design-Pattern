package com.example.designpattern.SnakeAndLadderGame.Models;

public class Ladder extends BoardEntity {
    public Ladder(int start, int end) {
        super(start, end);
        if(start>=end){
            throw new IllegalArgumentException("For a ladder start cannot be less than end");
        }
    }
}
