package aocjava.year2020.new_day08;

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

//    Integer stepWithoutExecute() {
//        aocjava.year2020.day08.Instruction instruction = instructions.get(position);
////        boolean hasRunBefore = instruction.isExecuted();
//        int initialPosition = position;
//        step(instruction);
////        if(hasRunBefore) {
////            return initialPosition;
////        } else {
////            return null;
////        }
//        return initialPosition;
//    }

    private void step(Instruction instruction) {
        if(instruction.isAccumulator()) {
            accumulator += instruction.getArgument();
        }
        position += instruction.getNextOffset();
    }

//    public void reset() {
//        accumulator = 0;
//        position = 0;
//        for(Instruction instruction : instructions) {
//            instruction.reset();
//        }
//    }

    public int getAccumulator() {
        return accumulator;
    }
}