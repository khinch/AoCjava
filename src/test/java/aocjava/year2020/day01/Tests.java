package aocjava.year2020.day01;

import aocjava.BaseTest;
import aocjava.Clue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    private static Clue part1clue;
    private static Clue part2clue;

    @BeforeClass
    public void setup() {
        String clueInput = "1721\n"
                + "979\n"
                + "366\n"
                + "299\n"
                + "675\n"
                + "1456";
        part1clue = new Clue(clueInput,"514579");
        part2clue = new Clue(clueInput,"241861950");
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
