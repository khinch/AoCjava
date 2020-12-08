package aocjava.year2020.day08;

import java.util.List;

public class Analyser {

    public static void analyse(List<Instruction> instructionList) {
        Instruction instruction = new Instruction(Instruction.Operation.NOP, 4);
        instructionList.set(7, instruction);
    }
}