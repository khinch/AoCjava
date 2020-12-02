package aocjava.year2020.day02;

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
                "1-3 a: abcde\n" +
                "1-3 b: cdefg\n" +
                "2-9 c: ccccccccc";
        part1clue = new Clue(clueInput,"2");
        part2clue = new Clue(clueInput, "1");
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
