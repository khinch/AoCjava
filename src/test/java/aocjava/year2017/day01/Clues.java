package aocjava.year2017.day01;


import aocjava.Clue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * http://adventofcode.com/2017/day/1
 *
 *
 *
 */

public class Clues
{
    private static List<Clue> part1clues;
    private static List<Clue> part2clues;

    @BeforeClass
    public static void setup()
    {
        part1clues = new ArrayList<Clue>();
        part1clues.add(new Clue("1122", "3"));
        part1clues.add(new Clue("1111", "4"));
        part1clues.add(new Clue("1234", "0"));
        part1clues.add(new Clue("91212129", "9"));

        part2clues = new ArrayList<Clue>();
        part2clues.add(new Clue("1212", "6"));
        part2clues.add(new Clue("1221", "0"));
        part2clues.add(new Clue("123425", "4"));
        part2clues.add(new Clue("123123", "12"));
        part2clues.add(new Clue("12131415", "4"));
    }

    @Test
    public static void part1()
    {
        checkClues(part1clues);
    }

    @Test
    public static void part2()
    {
        checkClues(part2clues);
    }

    private static void checkClues(List<Clue> clues)
    {
        for(Clue clue : part1clues)
        {
            String input = clue.getInput();
            String expectedOutput = clue.getExpectedOutput();
            String actualOutput = Solve.part1(input);
            Assert.assertEquals(actualOutput, expectedOutput);
        }
    }
}
