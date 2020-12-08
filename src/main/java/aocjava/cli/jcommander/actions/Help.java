package aocjava.cli.jcommander.actions;

import com.beust.jcommander.Parameter;

public class Help implements CliAction {
    @Parameter(names = {"-h", "--help"}, description = "Show this help message", help = true, order = 401)
    private boolean showHelp = false;

    public boolean isShowHelp() {
        return showHelp;
    }
}