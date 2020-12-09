package aocjava.year2020.new_day08;

import aocjava.InvalidPuzzleInputException;

import java.util.LinkedList;
import java.util.List;

public class Instruction {

    private final List<Integer> comesFrom = new LinkedList<>();
    private final int argument;
    private final int nextOffset;
    private boolean executed = false;
    private boolean accumulator = false;
    private boolean jump = false;
    private boolean noop = false;
    private boolean endPath = false;

    public Instruction(String instructionString) {
        String[] instructionParts = instructionString.split(" ");
        this.argument = Integer.parseInt(instructionParts[1]);
        switch (instructionParts[0]) {
            case "acc":
                accumulator = true;
                nextOffset = 1;
                break;
            case "jmp":
                jump = true;
                nextOffset = argument;
                break;
            case "nop":
                noop = true;
                nextOffset = 1;
                break;
            default:
                throw new InvalidPuzzleInputException("Unexpected operation: " + instructionParts[0]);
        }
    }

    public void execute() {
        executed = true;
    }

    public int getArgument() {
        return argument;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void addComeFrom(int index) {
        comesFrom.add(index);
    }

    public void markAsEndPath() {
        endPath = true;
    }

    public boolean isEndPath() {
        return endPath;
    }

    public int getNextOffset() {
        return nextOffset;
    }

    public List<Integer> getComesFrom() {
        return comesFrom;
    }

    public boolean isAccumulator() {
        return accumulator;
    }

    public boolean isJump() {
        return jump;
    }

    public boolean isNoop() {
        return noop;
    }
}
