package aocjava.year2020.day08;

import java.util.List;

public class Controller {

    List<Instruction> instructions;
    int position = 0;
    int accumulator = 0;

    public Controller(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public int execute() {
        while(position < instructions.size()) {
            Instruction instruction = instructions.get(position);
            if(instruction.isExecuted()) {
                return accumulator;
            }
            instruction.execute();
            step(instruction);
        }
        return accumulator;
    }

    Integer stepWithoutExecute() {
        Instruction instruction = instructions.get(position);
//        boolean hasRunBefore = instruction.isExecuted();
        int initialPosition = position;
        step(instruction);
//        if(hasRunBefore) {
//            return initialPosition;
//        } else {
//            return null;
//        }
        return initialPosition;
    }

    private void step(Instruction instruction) {
        switch (instruction.getOperation()) {
            case NOP:
                position++;
                break;
            case ACC:
                accumulator += instruction.getArgument();
                position++;
                break;
            case JMP:
                position += instruction.getArgument();
                break;
            default:
                throw new UnsupportedOperationException("Expected NOP, ACC or JMP, received " + instruction.getOperation());
        }
    }

    public void reset() {
        accumulator = 0;
        position = 0;
        for(Instruction instruction : instructions) {
            instruction.reset();
        }
    }
}