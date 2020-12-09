package aocjava.year2020.day09;

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
            "35\n" +
            "20\n" +
            "15\n" +
            "25\n" +
            "47\n" +
            "40\n" +
            "62\n" +
            "55\n" +
            "65\n" +
            "95\n" +
            "102\n" +
            "117\n" +
            "150\n" +
            "182\n" +
            "127\n" +
            "219\n" +
            "299\n" +
            "277\n" +
            "309\n" +
            "576";
        part1clue = new Clue(clueInput,"127");
        part2clue = new Clue(clueInput, "62");
    }

    @Test
    public void part1() {
        testClue(new Part1(5), part1clue);
    }

    @Test
    public void part2() {
        testClue(new Part2(5), part2clue);
    }
}
