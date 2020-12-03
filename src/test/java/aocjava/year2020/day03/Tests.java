package aocjava.year2020.day03;

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
            "..##.......\n" +
            "#...#...#..\n" +
            ".#....#..#.\n" +
            "..#.#...#.#\n" +
            ".#...##..#.\n" +
            "..#.##.....\n" +
            ".#.#.#....#\n" +
            ".#........#\n" +
            "#.##...#...\n" +
            "#...##....#\n" +
            ".#..#...#.#";
        part1clue = new Clue(clueInput, "7");
        part2clue = new Clue(clueInput, "336");
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