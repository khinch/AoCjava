package aocjava.year2020.day12;

import aocjava.InvalidPuzzleInputException;

import java.awt.*;

public class Ship2 {

    private final Point position = new Point(0, 0);
    private final Point waypoint = new Point(10, 1);

    public void action(char direction, int distance) {
        switch (direction) {
            case 'F':
                moveForward(distance);
                break;
            case 'N':
                moveNorth(distance);
                break;
            case 'S':
                moveSouth(distance);
                break;
            case 'E':
                moveEast(distance);
                break;
            case 'W':
                moveWest(distance);
                break;
            case 'L':
                rotateWaypointLeft(distance);
                break;
            case 'R':
                rotateWaypointRight(distance);
        }

    }

    private void rotateWaypointLeft(int degrees) {
        if(degrees == 180) {
            rotatePi();
        } else if(degrees == 270) {
            rotateWaypointRight(90);
        } else if(degrees == 90) {
            int tmpx = waypoint.x;
            waypoint.x = -waypoint.y;
            waypoint.y = tmpx;
        } else {
            throw new InvalidPuzzleInputException("Unexpected rotation input: " + degrees);
        }
    }

    private void rotateWaypointRight(int degrees) {
        if(degrees == 180) {
            rotatePi();
        } else if(degrees == 270) {
            rotateWaypointLeft(90);
        } else if(degrees == 90) {
            int tmpx = waypoint.x;
            waypoint.x = waypoint.y;
            waypoint.y = -tmpx;
        } else {
            throw new InvalidPuzzleInputException("Unexpected rotation input: " + degrees);
        }
    }

    public Point getPosition() {
        return position;
    }

    private void moveForward(int iterations) {
        for(int i = 0; i < iterations; i++) {
            position.x = position.x + waypoint.x;
            position.y = position.y + waypoint.y;
        }
    }

    private void moveNorth(int distance) {
        waypoint.move(waypoint.x, waypoint.y + distance);
    }

    private void moveSouth(int distance) {
        waypoint.move(waypoint.x, waypoint.y - distance);
    }

    private void moveWest(int distance) {
        waypoint.move(waypoint.x - distance, waypoint.y);
    }

    private void moveEast(int distance) {
        waypoint.move(waypoint.x + distance, waypoint.y);
    }

    private void rotatePi() {
        waypoint.x = -waypoint.x;
        waypoint.y = -waypoint.y;
    }

}
