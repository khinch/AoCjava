package aocjava.year2020.day12;

import aocjava.Solvable;

import java.awt.*;

public class Part2 implements Solvable {

    // TODO refactor solution with a single ship object
    public String solve(String input) {
        String[] instructions = input.split("\n");
        Ship2 ship = new Ship2();
        for(String instruction : instructions) {
            char action = instruction.charAt(0);
            int amount = Integer.parseInt(instruction.substring(1));
            ship.action(action,amount);
        }
        Point destination = ship.getPosition();
        int x = destination.x;
        if(x < 0) {
            x += 2*(-x);
        }
        int y = destination.y;
        if(y < 0) {
            y += 2*(-y);
        }



        return Integer.toString(x + y);
    }
}