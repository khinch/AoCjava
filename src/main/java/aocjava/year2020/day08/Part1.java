package aocjava.year2020.day08;

import aocjava.ResolutionFailureException;
import aocjava.Solvable;

import java.util.LinkedList;
import java.util.List;

public class Part1 implements Solvable {

    List<Instruction> instructionList = new LinkedList<>();

    public String solve(String input) {
        parseInstructions(input.split("\n"));
        Controller controller = new Controller(instructionList);
        if(!controller.execute()) {
            return Integer.toString(controller.getAccumulator());
        } else {
            throw new ResolutionFailureException("Unexpectedly reached the end of execution without encountering a loop");
        }
    }

    private void parseInstructions(String... instructionStrings) {
        for(String instructionString : instructionStrings) {
            instructionList.add(new Instruction(instructionString));
        }
    }
}