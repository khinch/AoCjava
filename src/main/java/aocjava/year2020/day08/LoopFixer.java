package aocjava.year2020.day08;

import java.util.List;

public class LoopFixer {

    public static void fixLoop(List<Instruction> instructionList, int index) {
        instructionList.set(index, flip(instructionList.get(index)));
    }

    private static Instruction flip(Instruction instruction) {
        int argument = instruction.getArgument();
        Operation operation = instruction.getOperation();
        if(operation.equals(Operation.JMP)) {
            return new Instruction(Operation.NOP, argument);
        } else if (operation.equals(Operation.NOP)) {
            return new Instruction(Operation.JMP, argument);
        } else {
            throw new InvalidInstructionFlipException("Tried to flip invalid instruction - not NOP or JMP");
        }
    }
}