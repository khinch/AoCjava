package aocjava.year2020.day13;

import aocjava.Solvable;
import aocjava.utils.MathUtils;

import java.util.*;

public class Part2 implements Solvable {

    public String solve(String input) {
        String[] busStrings = input.split("\n")[1].split(",");
        ArrayList<Long> busList = new ArrayList<>();
        for(int i = 0; i < busStrings.length; i++) {
            String busString = busStrings[i];
            if(!busString.equals("x")) {
                busList.add(Long.parseLong(busString)-i);
            }
        }

        // TODO
        Long[] busArray = busList.toArray(new Long[0]);


        long answer = MathUtils.lowestCommonDenominator(busArray);
        return Long.toString(answer);
    }
}