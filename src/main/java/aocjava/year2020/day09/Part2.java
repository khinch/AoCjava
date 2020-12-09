package aocjava.year2020.day09;

import aocjava.ResolutionFailureException;
import aocjava.Solvable;

public class Part2 implements Solvable {

    private final int preamble;

    public Part2(int preamble) {
        this.preamble = preamble;
    }

    public String solve(String input) {
        XmasCracker xmasCracker = new XmasCracker(preamble, input.split("\n"));
        long weakness = xmasCracker.findWeakness();
        if(weakness < 0) {
            throw new ResolutionFailureException("Failed to find an invalid number in the list");
        } else {
            return Long.toString(weakness);
        }
    }
}