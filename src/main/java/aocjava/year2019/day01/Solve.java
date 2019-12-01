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
            totalFuel += calculateFuelRequiredForMass(mass);
        }
        return Integer.toString(totalFuel);
    }
    
    public static String part2(String input) {
        int totalFuel = 0;
        for(String moduleMassString : input.split("\n")) {
            int mass = Integer.parseInt(moduleMassString);
            totalFuel += calculateFuelRequiredForModule(mass);
        }
        return Integer.toString(totalFuel);
    }
    
    private static int calculateFuelRequiredForMass(int mass) {
        int fuelRequired = (mass / 3) - 2;
        return fuelRequired > 0 ? fuelRequired : 0;
    }
    
    private static int calculateFuelRequiredForModule(int mass) {
        int additionalFuel = calculateFuelRequiredForMass(mass);
        int aggregate = additionalFuel;
        while(additionalFuel != 0) {
            additionalFuel = calculateFuelRequiredForMass(additionalFuel);
            aggregate += additionalFuel;
        }
        return aggregate;
    }
}