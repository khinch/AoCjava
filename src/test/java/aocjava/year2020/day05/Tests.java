package aocjava.year2020.day05;

import aocjava.BaseTest;
import aocjava.Clue;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class Tests extends BaseTest {

    private static Clue part1clue;

    @BeforeClass
    public void setup() {
        String clueInput =
            "FBFBBFFRLR\n" +
            "BFFFBBFRRR\n" +
            "FFFBBBFRRR\n" +
            "BBFFBBFRLL\n";
        part1clue = new Clue(clueInput, "820");
    }

    @Test
    public void part1() {
        assertEquals(BoardingCard.calculateId("FBFBBFFRLR"), 357);
        assertEquals(BoardingCard.calculateId("BFFFBBFRRR"), 567);
        assertEquals(BoardingCard.calculateId("FFFBBBFRRR"), 119);
        assertEquals(BoardingCard.calculateId("BBFFBBFRLL"), 820);
        testClue(new Part1(), part1clue);
    }
}