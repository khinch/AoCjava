package aocjava.year2020.day07;

import aocjava.BaseTest;
import aocjava.Clue;
import org.testng.annotations.Test;

public class Tests extends BaseTest {
    private String part1clueInput =
        "light red bags contain 1 bright white bag, 2 muted yellow bags.\n" +
        "dark orange bags contain 3 bright white bags, 4 muted yellow bags.\n" +
        "bright white bags contain 1 shiny gold bag.\n" +
        "muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.\n" +
        "shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.\n" +
        "dark olive bags contain 3 faded blue bags, 4 dotted black bags.\n" +
        "vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.\n" +
        "faded blue bags contain no other bags.\n" +
        "dotted black bags contain no other bags.\n";;

    @Test
    public void part1() {
        Clue clue = new Clue(part1clueInput, "4");
        testClue(new Part1(), clue);
    }

    @Test
    public void part2() {
        String clueInput =
            "shiny gold bags contain 2 dark red bags.\n" +
            "dark red bags contain 2 dark orange bags.\n" +
            "dark orange bags contain 2 dark yellow bags.\n" +
            "dark yellow bags contain 2 dark green bags.\n" +
            "dark green bags contain 2 dark blue bags.\n" +
            "dark blue bags contain 2 dark violet bags.\n" +
            "dark violet bags contain no other bags.";
        Clue clue1 = new Clue(clueInput, "126");
        Clue clue2 = new Clue(part1clueInput, "32");
        testClue(new Part2(), clue1);
        testClue(new Part2(), clue2);
    }
}