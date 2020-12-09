package aocjava.year2020.day08;

import java.util.List;

public class Controller {

    List<Instruction> instructions;
    int position = 0;
    int accumulator = 0;

    public Controller(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public boolean execute() {
        while(position < instructions.size()) {
            Instruction instruction = instructions.get(position);
            if(instruction.isExecuted()) {
                return false;
            }
            instruction.execute();
            step(instruction);
        }
        return true;
    }

    private void step(Instruction instruction) {
        if(instruction.isAccumulator()) {
            accumulator += instruction.getArgument();
        }
        position += instruction.getNextOffset();
    }

    public int getAccumulator() {
        return accumulator;
    }
}