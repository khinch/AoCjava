package aocjava.cli.jcommander;

import com.beust.jcommander.Parameter;

public class ShowCompleted implements CliAction {

    @Parameter(names = {"-s", "--showcompleted"}, description = "Show the available solutions")
    private boolean showCompleted = false;

    public boolean isShowCompleted() {
        return showCompleted;
    }

}
