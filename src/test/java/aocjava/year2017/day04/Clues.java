package aocjava.year2017.day04;

import aocjava.Clue;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * http://adventofcode.com/2017/day/4
 */

public class Clues
{
    private static Clue part1clue;
    private static Clue part2clue;

    @BeforeClass
    public static void setup()
    {
        part1clue = new Clue("aa bb cc dd ee\n" +
                "aa bb cc dd aa\n" +
                "aa bb cc dd aaa",
                "2");
        part2clue = new Clue("abcde fghij\n" +
                "abcde xyz ecdab\n" +
                "a ab abc abd abf abj\n" +
                "iiii oiii ooii oooi oooo\n" +
                "oiii ioii iioi iiio",
                "3");
    }

    @Test
    public static void part1() throws Exception
    {
        Assert.assertEquals(aocjava.year2017.day04.Solve.part1(part1clue.getInput()), part1clue.getExpectedOutput());
    }

    @Test
    public static void part2() throws Exception
    {
        Assert.assertEquals(aocjava.year2017.day04.Solve.part2(part2clue.getInput()), part2clue.getExpectedOutput());
    }
}
