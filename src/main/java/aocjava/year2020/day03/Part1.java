package aocjava.year2020.day03;

import aocjava.Solvable;

public class Part1 implements Solvable {

    public String solve(String input) {
        String[] puzzleLines = input.split("\n");
        return Integer.toString(TreeCounter.countTrees(puzzleLines, 3, 1));
    }
}
