package aocjava.year2020.day08;

public class Instruction {

    private final int argument;
    private final Operation operation;
    private boolean executed = false;

    enum Operation { NOP, ACC, JMP }

    public Instruction(Operation operation, int argument) {
        this.operation = operation;
        this.argument = argument;
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
}
