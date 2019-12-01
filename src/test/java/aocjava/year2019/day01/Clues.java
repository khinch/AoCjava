/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aocjava.year2019.day01;

import aocjava.Clue;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * http://adventofcode.com/2019/day/1
 */

public class Clues {

    private static Clue part1clue;
    private static Clue part2clue;

    @BeforeClass
    public static void setup() {
        part1clue = new Clue("12\n"
                + "14\n"
                + "1969\n"
                + "100756",
                "34241");

        part2clue = new Clue("14\n"
                + "1969\n"
                + "100756",
                "51314");
    }

    @Test
    public static void part1() {
        String input = part1clue.getInput();
        String expectedOutput = part1clue.getExpectedOutput();
        String actualOutput = Solve.part1(input);
        Assert.assertEquals(actualOutput, expectedOutput);
    }
    
    @Test
    public static void part2() {
        String input = part2clue.getInput();
        String expectedOutput = part2clue.getExpectedOutput();
        String actualOutput = Solve.part2(input);
        Assert.assertEquals(actualOutput, expectedOutput);
    }
}