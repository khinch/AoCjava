package aocjava.cli;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class TestCliManager {

    private static final String PROGRAM_NAME = "AoCjava - tests";

    @Test
    void showHelpShort() {
        String[] args = {"-h"};
        assertShowHelp(args);
    }

    @Test
    void showHelpLong() {
        String[] args = {"--help"};
        assertShowHelp(args);
    }

    @Test
    void showHelpBoth() {
        String[] args = {"-h", "--help"};
        assertShowHelp(args);
    }

    private void assertShowHelp(String[] args) {
        CliManager cliManager = new CliManager(args, PROGRAM_NAME);
        cliManager.validateCliArgs();
        assertEquals(cliManager.getAction(), CliManager.Action.HELP);
    }
}
