package aocjava.year2020.day08;

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
            "nop +0\n" +
            "acc +1\n" +
            "jmp +4\n" +
            "acc +3\n" +
            "jmp -3\n" +
            "acc -99\n" +
            "acc +1\n" +
            "jmp -4\n" +
            "acc +6";
        part1clue = new Clue(clueInput, "5");
        part2clue = new Clue(clueInput, "8");
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
