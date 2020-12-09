package aocjava.year2020.new_day08;

import aocjava.ResolutionFailureException;
import aocjava.Solvable;

import java.util.LinkedList;
import java.util.List;

public class Part2 implements Solvable {

    List<Instruction> instructionList = new LinkedList<>();

    public String solve(String input) {
        parseInstructions(input.split("\n"));
        Analyser analyser = new Analyser(instructionList);
        flipInstruction(analyser.identifyFaultyInstruction());
        Controller controller = new Controller(instructionList);
        if(controller.execute()) {
            return Integer.toString(controller.getAccumulator());
        } else {
            throw new ResolutionFailureException("Failed to complete program execution");
        }
    }

    private void flipInstruction(int index) {
        Instruction initialInstruction = instructionList.get(index);
        String operation;
        if(initialInstruction.isNoop()) {
            operation = "jmp";
        } else if(initialInstruction.isJump()) {
            operation = "nop";
        } else {
            throw new UnsupportedOperationException("Can only flip jmp or nop operations");
        }
        Instruction newInstruction = new Instruction(operation + " " + initialInstruction.getArgument());
        instructionList.set(index, newInstruction);
    }

    private void parseInstructions(String... instructionStrings) {
        for(String instructionString : instructionStrings) {
            instructionList.add(new Instruction(instructionString));
        }
    }
}
