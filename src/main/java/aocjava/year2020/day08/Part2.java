package aocjava.year2020.day08;

import aocjava.Solvable;

import java.util.LinkedList;
import java.util.List;

public class Part2 implements Solvable {

    public String solve(String input) {
        List<Instruction> instructionList = InstructionParser.parse(input.split("\n"));
        Analyser analyser = new Analyser(instructionList);
        analyser.mapReverse();



        boolean errorFixed = false;
        while(!errorFixed) {
            List<Instruction> testList = new LinkedList<>(instructionList);

        }


        int errorIndex = Analyser.analyse(instructionList);
        LoopFixer.fixLoop(instructionList, errorIndex);
        Controller controller = new Controller(instructionList);
        return Integer.toString(controller.execute());
    }
}
