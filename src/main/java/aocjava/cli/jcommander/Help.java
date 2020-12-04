package aocjava.cli.jcommander;

import com.beust.jcommander.Parameter;

public class Help implements CliAction {
    @Parameter(names = {"-h", "--help"}, description = "Show this help message")
    private boolean showHelp = false;

    @Parameter(names = {"-s", "--showcompleted"}, description = "Show the available solutions")
    private boolean showCompleted = false;

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isShowCompleted() {
        return showCompleted;
    }
}
