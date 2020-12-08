package aocjava.cli.jcommander.validators;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

import java.io.File;

public class FileValidator implements IParameterValidator {

    public void validate(String name, String value) {

        File file = new File(value);
        if(!(file.exists() && file.canRead())) {
            throw new ParameterException("File does not exist, or is read only:\n\t" + value + "\n");
        }
    }
}