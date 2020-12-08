package aocjava.year2020.day08;

import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class InstructionParser {

    public static List<Instruction> parse(String... instructionStrings) {
        List<Instruction> instructionList = new LinkedList<>();
        for(String instructionString : instructionStrings) {
            String[] instructionParts = instructionString.split(" ");
            Instruction.Operation operation = Instruction.Operation.valueOf(instructionParts[0].toUpperCase(Locale.ROOT));
            int argument = Integer.parseInt(instructionParts[1]);
            Instruction instruction = new Instruction(operation, argument);
            instructionList.add(instruction);
        }
        return instructionList;
    }
}
