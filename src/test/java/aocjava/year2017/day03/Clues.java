package aocjava.year2017.day03;

import aocjava.Clue;
import aocjava.InvalidPuzzleInputException;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * http://adventofcode.com/2017/day/3
 */

public class Clues
{
    private static List<Clue> part1clues;

    @BeforeClass
    public static void setup()
    {
        part1clues = new ArrayList<Clue>();
        part1clues.add(new Clue("1", "0"));
        part1clues.add(new Clue("12", "3"));
        part1clues.add(new Clue("23", "2"));
        part1clues.add(new Clue("1024", "31"));
    }

    @Test
    public static void part1() throws InvalidPuzzleInputException
    {
        for(Clue clue : part1clues)
        {
            Assert.assertEquals(aocjava.year2017.day03.Solve.part1(clue.getInput()), clue.getExpectedOutput());
        }

    }

}
