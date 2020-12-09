package aocjava.year2020.day08;

import aocjava.InvalidPuzzleInputException;

import java.util.LinkedList;
import java.util.List;

public class Analyser {

    private final List<Instruction> instructionList;
    private final int endIndex;

    public Analyser(List<Instruction> instructionList) {
        this.instructionList = new LinkedList<>(instructionList);
        this.endIndex = instructionList.size();
    }

    public int identifyFaultyInstruction() {
        mapReverseSteps();
        List<Integer> penultimateIndices = findPenultimateIndices();
        for(int penultimateIndex : penultimateIndices) {
            walkEndPath(penultimateIndex);
        }
        return identifyFaultyIndex();
    }

    private void mapReverseSteps() {
        for(int i = 0; i < endIndex; i++) {
            Instruction current = instructionList.get(i);
            int forwardIndex = i + current.getNextOffset();
            if(forwardIndex < 0 || forwardIndex > endIndex) {
                throw new InvalidPuzzleInputException("Instruction on line " + (i-1) + "points to non-existent instruction");
            } else if (forwardIndex != endIndex) {
                instructionList.get(forwardIndex).addComeFrom(i);
            }
        }
    }

    private List<Integer> findPenultimateIndices() {
        List<Integer> penultimateIndices = new LinkedList<>();
        for(int i = 0; i < endIndex; i++) {
            Instruction instruction = instructionList.get(i);
            if(endIndex == i + instruction.getNextOffset()) {
                penultimateIndices.add(i);
            }
        }
        return penultimateIndices;
    }

    private void walkEndPath(int index) {
        Instruction instruction = instructionList.get(index);
        instruction.markAsEndPath();
        for(int previousIndex : instruction.getComesFrom()) {
            walkEndPath(previousIndex);
        }
    }

    /*
    Loop detector:
        anywhere we see a jmp-, there MUST be a jump+x within x-1 steps before it, or we have a loop.
    Loop fixer:
        The fix is not so simple due to the constraints of the question - do we flip the jmp- to a nop, or do we step
        backwards in search of a noop with a larger value than the difference and flip that?
     */

    private int identifyFaultyIndex() {
        int position = 0;
        while(position < endIndex) {
            Instruction instruction = instructionList.get(position);

            if(instruction.isJump() && instructionList.get(position+1).isEndPath()) {
                return position;
            } else if (instruction.isNoop() && instructionList.get(position+instruction.getArgument()).isEndPath()) {
                return position;
            }

            position += instruction.getNextOffset();
        }
        return -1;
    }

}