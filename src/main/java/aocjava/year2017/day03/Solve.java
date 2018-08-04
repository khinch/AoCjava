package aocjava.year2017.day03;

import aocjava.InvalidPuzzleInputException;

/**
 * Class to solve puzzle on 3rd Dec 2017
 *
 * http://adventofcode.com/2017/day/3
 *
 * TODO: Implement logging
 */

public class Solve
{

    public static String part1(String input) throws InvalidPuzzleInputException
    {
        int cell;
        try
        {
            cell = Integer.parseInt(input);
        } catch (NumberFormatException e)
        {
            throw new InvalidPuzzleInputException("Input contains non-numeric characters: " + input);
        }
        int level = getlevel(cell);
        int maxPath = level * 2;
        int maxLevelCell = (maxPath+1)*(maxPath+1);

        int distance;
        if(maxLevelCell == cell)
        {
            distance = maxPath;
        } else
        {
            int cellDifference = maxLevelCell - cell;
            if(cellDifference < level)
            {
                distance = level + (level - cellDifference);
            } else
            {
                int pathAddition = cellDifference % level;
                distance = level + pathAddition;
            }

        }

        return String.valueOf(distance);
    }

    public static String part2(String input) throws InvalidPuzzleInputException
    {
        return "not implemented;";
    }

    private static int getlevel(int cell)
    {
        double level = Math.sqrt(cell);
        level--;
        level = level/2;
        level = Math.ceil(level);
        return (int)level;
    }

}
