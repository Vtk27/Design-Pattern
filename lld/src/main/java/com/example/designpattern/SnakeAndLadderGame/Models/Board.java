package com.example.designpattern.SnakeAndLadderGame.Models;

import java.util.HashMap;
import java.util.List;

public class Board {
    private final int size;
    private final HashMap<Integer, Integer> snakeAndLadder;

    public Board(int size, List<BoardEntity> entities){
        this.size = size;
        snakeAndLadder = new HashMap<>();
        for(BoardEntity be: entities){
            snakeAndLadder.put(be.getStart(), be.getEnd());
        }
    }

    public int getFinalPosition(int position){
        return snakeAndLadder.getOrDefault(position, position);
    }

    public int getSize(){return size;}
}
