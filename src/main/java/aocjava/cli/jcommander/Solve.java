package aocjava.cli.jcommander;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

@Parameters(commandDescription = "Solve specific puzzle")
public class Solve implements CliAction {

    @Parameter(names = {"-y", "--year"},
            description = "Year of the puzzle to solve",
            required = true,
            validateWith = YearValidator.class,
            order = 100)
    private String year;

    @Parameter(names = {"-d", "--day"},
            description = "Day of the puzzle to solve",
            required = true,
            validateWith = DayValidator.class,
            order = 101)
    private String day;

    @Parameter(names = {"-p", "--part"},
            description = "Part of the puzzle to solve",
            required = true,
            validateWith = PartValidator.class,
            order = 102)
    private String part;

    @Parameter(names = {"-i", "--input"}, description = "Puzzle input", required = true, order = 103)
    private String input;

    public String getYear() {
        return year;
    }

    public String getDay() {
        return day;
    }

    public String getPart() {
        return part;
    }

    public String getInput() {
        return input;
    }
}
