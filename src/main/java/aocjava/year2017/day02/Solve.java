package aocjava.year2017.day02;

import aocjava.InvalidPuzzleInputException;

/**
 * Class to solve puzzle on 2nd Dec 2017
 *
 * http://adventofcode.com/2017/day/2
 *
 * TODO: Implement logging
 */

public class Solve
{

    public static String part1(String input) throws InvalidPuzzleInputException
    {
        int checksum = 0;

        for(String line : input.split("\n"))
        {
            int highest = Integer.MIN_VALUE;
            int lowest = Integer.MAX_VALUE;

            for(String cell : line.split("\\s+"))
            {
                int cellValue;
                try
                {
                    cellValue = Integer.valueOf(cell);
                } catch (NumberFormatException e)
                {
                    throw new InvalidPuzzleInputException("Input contains non-numeric characters: " + cell);
                }

                if (cellValue > highest)
                {
                    highest = cellValue;
                }
                if (cellValue < lowest)
                {
                    lowest = cellValue;
                }
            }

            checksum += (highest-lowest);
        }
        return String.valueOf(checksum);
    }

    public static String part2(String input) throws InvalidPuzzleInputException
    {
        return "Not yet implemented.";
    }

}
