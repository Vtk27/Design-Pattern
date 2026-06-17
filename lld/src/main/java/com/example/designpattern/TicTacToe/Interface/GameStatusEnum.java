package com.example.designpattern.TicTacToe.Interface;

public enum GameStatusEnum {
    INVALID("INVALID"),
    WON("WON"),
    DRAWN("DRAWN"),
    IN_PROGRESS("IN_PROGRESS");

    String status;
    GameStatusEnum(String status){
        this.status = status;
    }
    public String getStatus(){
        return status;
    }
}
