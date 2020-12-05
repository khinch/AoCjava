package aocjava.year2020.day05;

import aocjava.Solvable;

public class Part1 implements Solvable {

    public String solve(String input) {
        int highestSeat = 0;
        for(String boardingCardString : input.split("\n")) {
            int id = BoardingCard.calculateId(boardingCardString);
            if(id > highestSeat) {
                highestSeat = id;
            }
        }
        return Integer.toString(highestSeat);
    }
}
