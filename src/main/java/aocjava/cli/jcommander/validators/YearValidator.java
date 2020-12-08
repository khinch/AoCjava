package aocjava.cli.jcommander.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class YearValidator implements IParameterValidator {

    private static final String MESSAGE = "Format: YYYY. Supported years: 2015 onwards";

    public void validate(String name, String value) {
        int year;
        try {
            year = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new ParameterException(name + " " + MESSAGE);
        }
        if(year < 2015) {
            throw new ParameterException(name + " " + MESSAGE);
        }
    }
}