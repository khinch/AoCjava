package aocjava.year2020.day12;

import java.awt.*;

public class Ship {

    private final Point position = new Point(0, 0);
    private int heading = 90;

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
                turnLeft(distance);
                break;
            case 'R':
                turnRight(distance);
        }

    }

    private void turnLeft(int degrees) {
        if(heading >= degrees) {
            heading -= degrees;
        } else {
            heading = 360 - (degrees - heading);
        }
    }

    private void turnRight(int degrees) {
        heading += degrees;
        if(heading >= 360) {
            heading = heading % 360;
        }
    }

    public Point getPosition() {
        return position;
    }

    private void moveForward(int distance) {
        switch (heading) {
            case 0:
                moveNorth(distance);
                break;
            case 90:
                moveEast(distance);
                break;
            case 180:
                moveSouth(distance);
                break;
            case 270:
                moveWest(distance);
                break;
        }
    }

    private void moveNorth(int distance) {
        position.move(position.x, position.y + distance);
    }

    private void moveSouth(int distance) {
        position.move(position.x, position.y - distance);
    }

    private void moveWest(int distance) {
        position.move(position.x - distance, position.y);
    }

    private void moveEast(int distance) {
        position.move(position.x + distance, position.y);
    }

}
