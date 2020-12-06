package aocjava.cli.jcommander;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class PartValidator implements IParameterValidator {

    private static final String MESSAGE = "Must be 1 or 2";

    public void validate(String name, String value) {
        int part;
        try {
            part = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new ParameterException(name + " " + MESSAGE);
        }
        if(part < 1 || part > 2) {
            throw new ParameterException(name + " " + MESSAGE);
        }
    }
}