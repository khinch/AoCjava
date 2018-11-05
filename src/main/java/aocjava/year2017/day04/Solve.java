package aocjava.year2017.day04;


import aocjava.InvalidPuzzleInputException;

/**
 * Class to solve puzzle on 4th Dec 2017
 *
 * http://adventofcode.com/2017/day/4
 *
 * TODO: Implement logging
 */

public class Solve
{
    public static String part1(String input) throws InvalidPuzzleInputException
    {
        int total = 0;
        String[] passphrases = input.split("\n");
        for (String passphrase : passphrases)
        {
            if (new Passphrase(passphrase).isValid())
            {
                total++;
            }
        }
        return Integer.toString(total);
    }

    public static String part2(String input) throws InvalidPuzzleInputException
    {
        return "not implemented";
    }


}
