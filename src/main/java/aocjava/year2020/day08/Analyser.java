package aocjava.year2020.day08;

import java.util.LinkedList;
import java.util.List;

public class Analyser {

    private List<Instruction> instructionList;
    private final int maxIndex;
    private final int endIndex;

    public Analyser(List<Instruction> instructionList) {
        this.instructionList = instructionList;
        maxIndex = instructionList.size()-1;
        endIndex = instructionList.size();
    }

    public void mapReverse() {
        for(int i = 0; i < endIndex; i++) {
            Instruction current = instructionList.get(i);
            if(current.getOperation().equals(Operation.JMP)) {
                int forwardIndex = i + current.getArgument();
                // if(forwardIndex )
                instructionList.get(i + current.getArgument()).addComeFrom(i);
            } else {
                instructionList.get(i+1).addComeFrom(i);
            }
        }
    }

    public static int analyse(List<Instruction> instructionList) {
         List<Integer> loopIndices = loopDetector(instructionList);
         if(!loopIndices.isEmpty()) {
             return getErrorIndex(instructionList, loopIndices);
         } else {
             return -1;
         }


        // return 7;
    }

    private static List<Integer> loopDetector(List<Instruction> instructionList) {
        List<Integer> stepHistory = new LinkedList<>();
        Controller controller = new Controller(instructionList);
        controller.reset();
        Integer endIndex = 0;
        boolean loopDetected = false;
        for(Instruction instruction : instructionList) {
            Integer result = controller.stepWithoutExecute();
            if(stepHistory.contains(result)) {
                endIndex = result;
                loopDetected = true;
                break;
            }
            stepHistory.add(result);
        }
        if(loopDetected) {
            while(!stepHistory.get(0).equals(endIndex)) {
                stepHistory.remove(0);
            }
            return stepHistory;
        } else {
            return new LinkedList<>();
        }
    }

    private static int getErrorIndex(List<Instruction> instructionList, List<Integer> loopIndices) {
        for(int index : loopIndices) {
            Instruction instruction = instructionList.get(index);
            int argument = instruction.getArgument();
            Operation operation = instruction.getOperation();
            if((operation == Operation.JMP) && (argument < 0) || (operation == Operation.NOP) && (argument > 0)) {
                return index;
            }
        }
        return -1;
    }
}