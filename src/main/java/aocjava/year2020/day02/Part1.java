package aocjava.year2020.day02;

import aocjava.Solvable;

public class Part1 implements Solvable {

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
        String[] minMax = components[0].split("-");
        int min = Integer.parseInt(minMax[0]);
        int max = Integer.parseInt(minMax[1]);
        char validator = components[1].charAt(0);
        int count = 0;
        for(char character : components[2].toCharArray()) {
            if(character == validator) {
                count++;
            }
        }
        return min <= count && count <= max;
    }
}