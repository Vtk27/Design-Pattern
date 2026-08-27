package com.example.designpattern.SnakeAndLadderGame;

import java.util.Arrays;
import java.util.List;

import com.example.designpattern.SnakeAndLadderGame.Models.Board;
import com.example.designpattern.SnakeAndLadderGame.Models.BoardEntity;
import com.example.designpattern.SnakeAndLadderGame.Models.Dice;
import com.example.designpattern.SnakeAndLadderGame.Models.Ladder;
import com.example.designpattern.SnakeAndLadderGame.Models.Player;
import com.example.designpattern.SnakeAndLadderGame.Models.Snake;

public class SnakeAndLadderDemo {
    public static void main(String[] args) {
        List<BoardEntity> boardEntities = List.of(
                new Snake(17, 7), new Snake(54, 34),
                new Snake(62, 19), new Snake(98, 79),
                new Ladder(3, 38), new Ladder(24, 33),
                new Ladder(42, 93), new Ladder(72, 84)
        );

        List<Player> players = Arrays.asList(new Player("Alice", 1),new Player("Bob", 1),new Player("Charlie", 1));

        Game game = new Game.Builder()
                    .setBoard(new Board(100, boardEntities))
                    .setDice(new Dice(1, 6))
                    .setPlayer(players).Build();
        game.play();  
    }
}
