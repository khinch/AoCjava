package aocjava.year2020.day02;

import aocjava.Solvable;

public class Part2 implements Solvable {

    public String solve(String input) {
        String[] entryStrings = input.split("\n");
        int count = 0;
        for(String entryString : entryStrings) {
            if(isValid(entryString)) {
                count++;
            }
        }
        return Integer.toString(count);
    }

    private boolean isValid(String password) {
        String[] components = password.split(" ");
        String[] positions = components[0].split("-");
        int firstPosition = Integer.parseInt(positions[0]);
        int secondPosition = Integer.parseInt(positions[1]);
        char validator = components[1].charAt(0);
        String word = components[2];
        return validator == word.charAt(firstPosition-1) ^ validator == word.charAt(secondPosition-1);
    }
}