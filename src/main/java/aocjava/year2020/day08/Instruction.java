package aocjava.year2020.day08;

import java.util.LinkedList;
import java.util.List;

public class Instruction {

    private final int argument;
    private final Operation operation;
    private boolean executed = false;
    private final List<Integer> comeFrom = new LinkedList<>();
    private boolean endPath = false;
    private int nextOffset;

    public Instruction(Operation operation, int argument) {
        this.operation = operation;
        this.argument = argument;
        if(operation.equals(Operation.JMP)) {
            nextOffset = argument;
        } else {
            nextOffset = 1;
        }
    }

    public void execute() {
        executed = true;
    }

    public int getArgument() {
        return argument;
    }

    public Operation getOperation() {
        return operation;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void reset() {
        executed = false;
    }

    public void addComeFrom(int index) {
        comeFrom.add(index);
    }

    public void onEndPath() {
        endPath = true;
    }

    public boolean isEndPath() {
        return endPath;
    }

    public int getNextOffset() {
        return nextOffset;
    }
}
