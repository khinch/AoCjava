package aocjava.year2020.day01;

import aocjava.ResolutionFailureException;
import aocjava.Solvable;

import java.util.LinkedList;
import java.util.List;

public class Part1 implements Solvable {

    private static final int TARGET = 2020;

    public String solve(String input) {
        String[] entryStrings = input.split("\n");
        List<Integer> entries = new LinkedList<>();
        for(String entryString : entryStrings) {
            entries.add(Integer.parseInt(entryString));
        }

        for(int i = 0; i < entries.size()-1; i++) {
            int num1 = entries.get(i);
            for(int j = i+1; j < entries.size(); j++) {
                int num2 = entries.get(j);
                if(num1 + num2 == TARGET) {
                    return Integer.toString(num1 * num2);
                }
            }
        }

        throw new ResolutionFailureException("Failed to find solution");
    }
}