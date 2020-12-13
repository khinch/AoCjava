package aocjava.year2020.day12;

import aocjava.BaseTest;
import aocjava.Clue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    private static Clue part1clue;
     private static Clue part2clue;

    @BeforeClass
    public void setup() {
        String clueInput =
            "F10\n" +
            "N3\n" +
            "F7\n" +
            "R90\n" +
            "F11";
        part1clue = new Clue(clueInput,"25");
         part2clue = new Clue(clueInput,"286");
    }

    @Test
    public void part1() {
        testClue(new Part1(), part1clue);
    }

    @Test
    public void part2() {
        testClue(new Part2(), part2clue);
    }
}
