package com.example.designpattern.SnakeAndLadderGame.Models;

public class Snake extends BoardEntity {
    public Snake(int start, int end){
        super(start, end);
        if(start<=end){
            throw new IllegalArgumentException("Snake cannot have start higher than end");
        }
    }
}
