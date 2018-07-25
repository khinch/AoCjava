package aocjava.year2017.day02;

import aocjava.Clue;
import aocjava.InvalidPuzzleInputException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * http://adventofcode.com/2017/day/2
 */

public class Clues
{
    private static Clue part1clue;

    @BeforeClass
    public static void setup()
    {
        part1clue = new Clue(
                "5 1 9 5\n" +
                "7 5 3\n" +
                "2 4 6 8",
        "18");
    }

    @Test
    public static void part1() throws InvalidPuzzleInputException
    {
        Assert.assertEquals(aocjava.year2017.day02.Solve.part1(part1clue.getInput()), part1clue.getExpectedOutput());
    }
}
