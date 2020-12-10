package aocjava.year2020.day10;

import aocjava.InvalidPuzzleInputException;
import aocjava.Solvable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part1 implements Solvable {

    public String solve(String input) {
        List<Integer> adaptors = new ArrayList<>();
        for(String adaptorString : input.split("\n")) {
            adaptors.add(Integer.parseInt(adaptorString));
        }
        adaptors.add(0);
        Collections.sort(adaptors);
        int ones = 0;
        int threes = 1;
        for(int i = 0; i < adaptors.size()-1; i++) {
            int difference = adaptors.get(i+1) - adaptors.get(i);
            if(difference == 1) {
                ones++;
            } else if(difference == 3) {
                threes++;
            } else {
                throw new InvalidPuzzleInputException("Expected difference of 1 or 3, got " + difference);
            }
        }

        return Integer.toString(ones * threes);
    }
}
