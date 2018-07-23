package aocjava.year2017.day01;

import aocjava.InvalidPuzzleInputException;

/**
 * Class to solve puzzle on 1st Dec 2017
 *
 * TODO: Implement logging
 */

public class Solve
{
    public static String part1(String input) throws InvalidPuzzleInputException
    {
        return solveCaptcha(input, 1);
    }

    public static String part2(String input) throws InvalidPuzzleInputException
    {
        if(input.length()%2 != 0)
        {
            throw  new InvalidPuzzleInputException("Input length is an odd number (" + input.length() + ". Input: \"" + input + "\".");
        }
        int offset = input.length()/2;
        return solveCaptcha(input, offset);
    }

    private static String solveCaptcha(String input, int offset) throws InvalidPuzzleInputException
    {
        int total = 0;
        int comparator = offset;

        for(char c : input.toCharArray())
        {
            if(!Character.isDigit(c))
            {
                throw new InvalidPuzzleInputException("Input contains non-numeric character: \"" + String.valueOf(c) + "\". Input: \"" + input + "\"");
            }
            if(c == input.charAt(comparator))
            {
                total += Integer.parseInt(String.valueOf(c));
            }
            if(comparator == input.length()-1)
            {
                comparator = 0;
            } else
            {
                comparator++;
            }
        }

        return String.valueOf(total);
    }


}
