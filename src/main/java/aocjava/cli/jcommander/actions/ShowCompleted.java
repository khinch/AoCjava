package aocjava.cli.jcommander.actions;

import com.beust.jcommander.Parameter;

public class ShowCompleted implements CliAction {

    @Parameter(names = {"-s", "--showcompleted"}, description = "Show the available solutions", help = true, order = 301)
    private boolean showCompleted = false;

    public boolean isShowCompleted() {
        return showCompleted;
    }

}
