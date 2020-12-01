package aocjava.year2020.day01;

import aocjava.ResolutionFailureException;
import aocjava.Solvable;

import java.util.LinkedList;
import java.util.List;

public class Part2 implements Solvable {

    private static final int TARGET = 2020;

    public String solve(String input) {
        String[] entryStrings = input.split("\n");
        List<Integer> entries = new LinkedList<>();
        for(String entryString : entryStrings) {
            entries.add(Integer.parseInt(entryString));
        }

        for(int i = 0; i < entries.size()-2; i++) {
            int num1 = entries.get(i);
            for(int j = i+1; j < entries.size()-1; j++) {
                int num2 = entries.get(j);
                for(int k = j+1; k < entries.size(); k++) {
                    int num3 = entries.get(k);
                    if(num1 + num2 + num3 == TARGET) {
                        return Integer.toString(num1 * num2 * num3);
                    }
                }
            }
        }

        throw new ResolutionFailureException("Failed to find solution");
    }
}