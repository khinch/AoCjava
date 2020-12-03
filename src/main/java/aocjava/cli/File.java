package aocjava.cli;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Solve all solutions in JSON file")
public class File {

    // @Parameter(names = {"-f", "--file"}, description = "filepath", required = true, order = 200)
    @Parameter(description = "filepath", required = true, converter = StringToFileConverter.class)
    private java.io.File filepath;

    public java.io.File getFilepath() {
        return filepath;
    }

}
