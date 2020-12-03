package aocjava.cli;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class TestJcommander {

    private static final String PROGRAM_NAME = "AoCjava - tests";

    @Test
    void showHelpShort() {
        String[] args = {"-h"};
        CliValidator validator = new CliValidator(args, PROGRAM_NAME);
        validator.validateCliArgs();
    }

    @Test
    void showHelpLong() {
        String[] args = {"--help"};
        CliValidator validator = new CliValidator(args, PROGRAM_NAME);
        validator.validateCliArgs();
    }

    @Test
    void showHelpBoth() {
        String[] args = {"-h", "--help"};
        CliValidator validator = new CliValidator(args, PROGRAM_NAME);
        validator.validateCliArgs();
    }
}
