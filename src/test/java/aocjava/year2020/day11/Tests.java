package aocjava.year2020.day11;

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
            "L.LL.LL.LL\n" +
            "LLLLLLL.LL\n" +
            "L.L.L..L..\n" +
            "LLLL.LL.LL\n" +
            "L.LL.LL.LL\n" +
            "L.LLLLL.LL\n" +
            "..L.L.....\n" +
            "LLLLLLLLLL\n" +
            "L.LLLLLL.L\n" +
            "L.LLLLL.LL";
        part1clue = new Clue(clueInput, "37");
        part2clue = new Clue(clueInput, "26");
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
