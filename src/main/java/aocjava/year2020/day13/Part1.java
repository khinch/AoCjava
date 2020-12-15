package aocjava.year2020.day13;

import aocjava.Solvable;

import java.util.LinkedList;
import java.util.List;

public class Part1 implements Solvable {

    public String solve(String input) {
        int timestamp = Integer.parseInt(input.split("\n")[0]);
        String[] busStrings = input.split("\n")[1].split(",");
        List<Integer> buses = new LinkedList<>();
        for(String busString : busStrings) {
            if(!busString.equals("x")) {
                buses.add(Integer.parseInt(busString));
            }
        }

        int soonest = Integer.MAX_VALUE;
        int soonestBus = 0;
        for(int bus : buses) {
            int waitTime = bus - (timestamp % bus);
            if(waitTime < soonest) {
                soonest = waitTime;
                soonestBus = bus;
            }
        }
        return Integer.toString(soonest * soonestBus);
    }
}