package aocjava.year2019.day01;

/**
 * Class to solve puzzle on 1st Dec 2019
 *
 * http://adventofcode.com/2019/day/1
 *
 * TODO: Implement logging
 */
public class Solve {
    
    public static String part1(String input) {
        int totalFuel = 0;
        for(String moduleMassString : input.split("\n")) {
            int mass = Integer.parseInt(moduleMassString);
            totalFuel += calculateFuelRequired(mass);
        }
        return Integer.toString(totalFuel);
    }
    
    private static int calculateFuelRequired(int mass) {
        return (mass / 3) - 2;
    }
    
}
