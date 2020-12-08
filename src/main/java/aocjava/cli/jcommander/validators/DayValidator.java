package aocjava.cli.jcommander.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class DayValidator implements IParameterValidator {

    private static final String MESSAGE = "Must be between 1 to 25 inclusive";

    public void validate(String name, String value) {
        int day;
        try {
            day = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new ParameterException(name + " " + MESSAGE);
        }
        if(day < 1 || day > 25) {
            throw new ParameterException(name + " " + MESSAGE);
        }
    }
}