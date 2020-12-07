package aocjava.year2020.day07;

import aocjava.Solvable;

public class Part1 extends Day07 implements Solvable {

    public String solve(String input) {
        BagOperations ops = new BagOperations(input.split("\n"));
        return Integer.toString(ops.getContainersOf(TARGET_COLOUR).size());
    }
}