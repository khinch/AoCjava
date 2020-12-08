package aocjava.cli;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.beust.jcommander.ParameterException;
import org.testng.annotations.Test;

public class TestCliManager {

    private static final String PROGRAM_NAME = "AoCjava - tests";

    @Test
    void showHelpValid() {
        assertCliAction(CliManager.Action.HELP, "-h");
        assertCliAction(CliManager.Action.HELP, "--help");
        assertCliAction(CliManager.Action.HELP, "-h", "--showcompleted");
        assertCliAction(CliManager.Action.HELP, "-s", "--help");
        assertCliAction(CliManager.Action.HELP, "-h", "file", "/home/johndoe/myfile.json");
        assertCliAction(CliManager.Action.HELP,
                "--help", "solve", "-y", "2015", "-d", "01", "-p", "2", "-i", "test input");
    }

    @Test
    void showCompletedValid() {
        assertCliAction(CliManager.Action.SHOWCOMPLETED, "-s");
        assertCliAction(CliManager.Action.SHOWCOMPLETED, "--showcompleted");
        assertCliAction(CliManager.Action.SHOWCOMPLETED, "-s", "file", "/my/path");
        assertCliAction(CliManager.Action.SHOWCOMPLETED,
                "--showcompleted", "solve", "-y", "2015", "-d", "01", "-p", "2", "-i", "test input");
    }

    @Test
    void fileValid() {
        assertCliAction(CliManager.Action.FILE, "file", "/my/path");
        assertCliAction(CliManager.Action.FILE, "file", "C:\\my\\path");
    }

    @Test
    void solveValid() {
        assertCliAction(CliManager.Action.SOLVE, "solve", "-y", "2015", "-d", "01", "-p", "2", "-i", "test input");
        assertCliAction(CliManager.Action.SOLVE, "solve", "-i", "test input", "-p", "2", "-d", "01", "-y", "2015");
        assertCliAction(CliManager.Action.SOLVE,
                "solve", "--year", "2015", "--day", "01", "--part", "2", "--input", "test input");
        assertCliAction(CliManager.Action.SOLVE,
                "solve", "-y", "2015", "--day", "01", "-p", "2", "--input", "test input");
    }

    @Test
    void fileInvalid() {
        assertExceptionMessage("Main parameters are required (\"filepath\")",
                "file");
        assertExceptionMessage("Only one main parameter allowed but found several: \"two\" and \"paths\"",
                "file", "two", "paths");
    }

    @Test
    void solveInvalid() {
        assertExceptionMessage("-y Format: YYYY. Supported years: 2015 onwards",
                "solve", "-y", "-d", "-p", "-i");
        assertExceptionMessage("Was passed main parameter '-z' but no main parameter was defined in your arg class",
                "solve", "-z");
        assertExceptionMessage("The following options are required: [-d | --day], [-p | --part], [-y | --year], [-i | --input]",
                "solve");
    }

    private void assertCliAction(CliManager.Action action, String... args) {
        CliManager cliManager = new CliManager(args, PROGRAM_NAME);
        cliManager.validateCliArgs();
        assertEquals(cliManager.getAction(), action);
    }

    private void assertExceptionMessage(String message, String... args) {
        CliManager cliManager = new CliManager(args, PROGRAM_NAME);
        try {
            cliManager.validateCliArgs();
            fail("Validation succeeded when exception was expected");
        } catch (ParameterException e) {
            assertEquals(e.getMessage(), message);
        }
    }
}
