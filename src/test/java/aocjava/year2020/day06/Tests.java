package aocjava.year2020.day06;

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
            "abc\n" +
            "\n" +
            "a\n" +
            "b\n" +
            "c\n" +
            "\n" +
            "ab\n" +
            "ac\n" +
            "\n" +
            "a\n" +
            "a\n" +
            "a\n" +
            "a\n" +
            "\n" +
            "b\n";
        part1clue = new Clue(clueInput, "11");
        part2clue = new Clue(clueInput, "6");
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