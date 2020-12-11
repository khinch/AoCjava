package aocjava.year2020.day11;

import aocjava.Solvable;

public class Part2 implements Solvable {

    public String solve(String input) {
        WaitingArea waitingArea = new WaitingArea(false, 5, input.split("\n"));
        while(waitingArea.shift());
        return Integer.toString(waitingArea.countAllOccupied());
    }
}