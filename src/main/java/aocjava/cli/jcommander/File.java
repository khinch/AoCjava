package aocjava.cli.jcommander;

import aocjava.cli.StringToFileConverter;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Solve all solutions in JSON file")
public class File implements CliAction {

    // @Parameter(names = {"-f", "--file"}, description = "filepath", required = true, order = 200)
    @Parameter(description = "filepath", required = true, converter = StringToFileConverter.class)
    private java.io.File filepath;

    public java.io.File getFilepath() {
        return filepath;
    }

}
