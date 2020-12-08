package aocjava.year2020.day08;

import java.util.List;

public class Controller {

    List<Instruction> instructions;
    int position;
    int accumulator;

    public Controller(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public int execute() {
        accumulator = 0;
        position = 0;
        while(position < instructions.size()) {
            Instruction instruction = instructions.get(position);
            if(instruction.isExecuted()) {
                return accumulator;
            } else {
                instruction.execute();
            }
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
        return accumulator;
    }
}