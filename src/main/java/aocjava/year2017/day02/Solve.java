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
        int total = 0;

        for(String line : input.split("\n"))
        {
            String[] charNums = line.split("\\s+");
            int[] nums = new int[charNums.length];
            for(int i = 0; i < nums.length; i++)
            {
                try
                {
                    nums[i] = Integer.valueOf(charNums[i]);
                } catch (NumberFormatException e)
                {
                    throw new InvalidPuzzleInputException("Input contains non-numeric characters: " + charNums[i]);
                }
            }

            boolean lineDone = false;
            for(int i = 0; i < nums.length-1; i++)
            {
                for(int j = i+1; j < nums.length; j++)
                {
                    int a = nums[i];
                    int b = nums[j];
                    if(a>b && a%b == 0)
                    {
                        total += a/b;
                        lineDone = true;
                        break;
                    } else if (b>a && b%a == 0)
                    {
                        total += b/a;
                        lineDone = true;
                        break;
                    }
                }
                if(lineDone)
                {
                    break;
                }
            }
        }

        return String.valueOf(total);
    }

}
