package aocjava.year2020.day10;

import aocjava.InvalidPuzzleInputException;
import aocjava.Solvable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Part1 implements Solvable {

    public String solve(String input) {
        List<Integer> adapters = new ArrayList<>();
        for(String adapterString : input.split("\n")) {
            adapters.add(Integer.parseInt(adapterString));
        }
        adapters.add(0);
        Collections.sort(adapters);
        int ones = 0;
        int threes = 1;
        for(int i = 0; i < adapters.size()-1; i++) {
            int difference = adapters.get(i+1) - adapters.get(i);
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