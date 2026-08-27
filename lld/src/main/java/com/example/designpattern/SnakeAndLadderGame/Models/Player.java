package com.example.designpattern.SnakeAndLadderGame.Models;

public class Player {
    String name;
    int position;

    public Player(String name, int position){
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    
}
