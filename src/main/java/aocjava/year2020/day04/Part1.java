package aocjava.year2020.day04;

import aocjava.Solvable;

public class Part1 implements Solvable {

    private static final String RECORD_SEPARATOR = "\n\n";

    public String solve(String input) {
        int count = 0;
        for(String passport : input.split(RECORD_SEPARATOR)) {
            PassportValidator passportValidator = new PassportValidator(passport);
            if(passportValidator.hasRequiredFields()) {
                count++;
            }
        }
        return Integer.toString(count);
    }
}