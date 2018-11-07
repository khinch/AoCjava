package aocjava.year2017.day04;

import aocjava.year2017.day04.Passphrase.Validator;

/**
 * Class to solve puzzle on 4th Dec 2017
 *
 * http://adventofcode.com/2017/day/4
 *
 * TODO: Implement logging
 */

public class Solve
{
    public static String part1(String input) throws Exception
    {
        return solve(input, Validator.EQUALITY);
    }

    public static String part2(String input) throws Exception
    {
        return solve(input, Validator.ANAGRAM);
    }

    private static String solve(String input, Validator validator) throws Exception
    {
        int total = 0;
        String[] phraseStrings = input.split("\n");
        for (String phraseString : phraseStrings)
        {
            Passphrase passphrase = new Passphrase(phraseString, validator);
            if (passphrase.isValid())
            {
                total++;
            }
        }
        return Integer.toString(total);
    }


}
