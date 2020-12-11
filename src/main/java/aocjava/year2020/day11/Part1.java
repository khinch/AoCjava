package aocjava.year2020.day11;

import aocjava.Solvable;

public class Part1 implements Solvable {

    public String solve(String input) {
        WaitingArea waitingArea = new WaitingArea(true, 4, input.split("\n"));
        while(waitingArea.shift());
        return Integer.toString(waitingArea.countAllOccupied());
    }
}