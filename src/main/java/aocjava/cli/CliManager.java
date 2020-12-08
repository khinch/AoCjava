package aocjava.cli;

import aocjava.cli.jcommander.actions.File;
import aocjava.cli.jcommander.actions.Help;
import aocjava.cli.jcommander.actions.ShowCompleted;
import aocjava.cli.jcommander.actions.Solve;
import com.beust.jcommander.JCommander;

public class CliManager {

    private final String[] args;
    private final String programName;
    private JCommander jCommander;

    Solve solve = new Solve();
    File file = new File();
    Help help = new Help();
    ShowCompleted showCompleted = new ShowCompleted();

    public enum Action {
        FILE,
        HELP,
        SHOWCOMPLETED,
        SOLVE
    }

    public CliManager(String[] args, String programName) {
        this.args = args;
        this.programName = programName;
    }

    public Action getAction() {

        if(help.isShowHelp()) {
            return Action.HELP;
        } else if (showCompleted.isShowCompleted()) {
            return Action.SHOWCOMPLETED;
        }

        if(jCommander.getParsedCommand() == null) {
            throw new UnexpectedActionException("Didn't receive showhelp or showcompleted. Expected a command.");
        }

        String parsedCommand = jCommander.getParsedCommand();
        if(parsedCommand.equals("file")) {
            return Action.FILE;
        } else if (parsedCommand.equals("solve")) {
            return Action.SOLVE;
        } else {
            throw new UnexpectedActionException("Expected one of: help, show completed, file, solve.\n" +
                    "This is an internal error");
        }
    }

    public File getFile() {
        return file;
    }

    public Solve getSolve() {
        return solve;
    }

    public void validateCliArgs() {
        jCommander = JCommander.newBuilder()
            .addObject(help)
            .addObject(showCompleted)
            .addCommand("file", file)
            .addCommand("solve", solve)
            .build();
        jCommander.setProgramName(programName);
        jCommander.setCaseSensitiveOptions(false);
        jCommander.parse(args);
    }

    public void printUsage() {
        jCommander.usage();
    }

    public void showHelp() {
        jCommander.usage();
    }
}