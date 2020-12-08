package aocjava.year2020.day08;

import aocjava.Solvable;

import java.util.List;

public class Part2 implements Solvable {

    public String solve(String input) {
        List<Instruction> instructionList = InstructionParser.parse(input.split("\n"));
        Analyser.analyse(instructionList);
        Controller controller = new Controller(instructionList);
        return Integer.toString(controller.execute());
    }
}
