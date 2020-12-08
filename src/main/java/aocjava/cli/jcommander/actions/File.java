package aocjava.cli.jcommander.actions;

import aocjava.cli.jcommander.validators.FileValidator;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Solve all solutions in JSON file")
public class File implements CliAction {

    @Parameter(description = "filepath",
            required = true,
            converter = StringToFileConverter.class,
            validateWith = FileValidator.class,
            order = 201)
    private java.io.File filepath;

    public java.io.File getFilepath() {
        return filepath;
    }

}
