package aocjava.year2017.day04;

import aocjava.Clue;
import aocjava.InvalidPuzzleInputException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * http://adventofcode.com/2017/day/4
 */

public class Clues
{
    private static Clue part1clue;

    @BeforeClass
    public static void setup()
    {
        part1clue = new Clue("aa bb cc dd ee\n" +
                "aa bb cc dd aa\n" +
                "aa bb cc dd aaa",
                "2");
    }

    @Test
    public static void part1() throws InvalidPuzzleInputException
    {
        Assert.assertEquals(aocjava.year2017.day04.Solve.part1(part1clue.getInput()), part1clue.getExpectedOutput());
    }
}
