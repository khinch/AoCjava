package aocjava.cli;

import com.beust.jcommander.JCommander;

public class CliValidator {

    private final String[] args;
    private final String programName;

    public CliValidator(String[] args, String programName) {
        this.args = args;
        this.programName = programName;
    }

    public void validateCliArgs() {
        Solve solve = new Solve();
        File file = new File();
        Help help = new Help();
        JCommander jCommander = JCommander.newBuilder()
                .addCommand("solve", solve)
                .addCommand("file", file)
                .addObject(help)
                .build();

        jCommander.setProgramName(programName);
        jCommander.setCaseSensitiveOptions(false);
        jCommander.parse(args);
    }
}