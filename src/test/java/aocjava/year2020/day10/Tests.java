package aocjava.year2020.day10;

import aocjava.BaseTest;
import aocjava.Clue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    private static String clueInput1;
    private static String clueInput2;

    @BeforeClass
    public void setup() {
        clueInput1 =
            "16\n" +
            "10\n" +
            "15\n" +
            "5\n" +
            "1\n" +
            "11\n" +
            "7\n" +
            "19\n" +
            "6\n" +
            "12\n" +
            "4";
        clueInput2 =
            "28\n" +
            "33\n" +
            "18\n" +
            "42\n" +
            "31\n" +
            "14\n" +
            "46\n" +
            "20\n" +
            "48\n" +
            "47\n" +
            "24\n" +
            "23\n" +
            "49\n" +
            "45\n" +
            "19\n" +
            "38\n" +
            "39\n" +
            "11\n" +
            "1\n" +
            "32\n" +
            "25\n" +
            "35\n" +
            "8\n" +
            "17\n" +
            "7\n" +
            "9\n" +
            "4\n" +
            "2\n" +
            "34\n" +
            "10\n" +
            "3";
    }

    @Test
    public void part1() {
        Part1 part1 = new Part1();
        testClue(part1, new Clue(clueInput1,"35"));
        testClue(part1, new Clue(clueInput2,"220"));
    }

    @Test
    public void part2() {
        testClue(new Part2(), new Clue(clueInput1,"8"));
        testClue(new Part2(), new Clue(clueInput2,"19208"));
    }
}
