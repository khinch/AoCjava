package aocjava.year2020.day03;

import aocjava.Solvable;

public class Part2 implements Solvable {

    public String solve(String input) {
        String[] lines = input.split("\n");
        long trees = TreeCounter.countTrees(lines, 1, 1);
        trees = trees * TreeCounter.countTrees(lines, 3, 1);
        trees = trees * TreeCounter.countTrees(lines, 5, 1);
        trees = trees * TreeCounter.countTrees(lines, 7, 1);
        trees = trees * TreeCounter.countTrees(lines, 1, 2);
        return Long.toString(trees);
    }
}