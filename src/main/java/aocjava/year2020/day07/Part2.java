package aocjava.year2020.day07;

import aocjava.Solvable;

public class Part2 extends Day07 implements Solvable {

    public String solve(String input) {
        BagOperations ops = new BagOperations(input.split("\n"));
        return Integer.toString(ops.countAllContainedBags(TARGET_COLOUR));
    }
}