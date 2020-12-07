package aocjava.year2020.day06;

import aocjava.Solvable;

import java.util.HashSet;
import java.util.Set;

public class Part1 implements Solvable {

    public String solve(String input) {
        int sum = 0;
        for(String group : input.split("\n\n")) {
            Set<Character> groupPositives = new HashSet<>();
            for(Character answer : group.replace("\n", "").toCharArray()) {
                groupPositives.add(answer);
            }
            sum += groupPositives.size();
        }
        return Integer.toString(sum);
    }
}