package aocjava.year2020.day11;

import aocjava.InvalidPuzzleInputException;
import static aocjava.utils.MathUtils.smallestOf;
import java.util.LinkedList;
import java.util.List;

public class WaitingArea {

    private final Position[][] positions;
    private final int rows;
    private final int columns;
    private final boolean adjacentNeighboursOnly;
    private final int tolerance;


    public WaitingArea(boolean adjacentNeighboursOnly, int tolerance, String... seatLayout) {
        this.adjacentNeighboursOnly = adjacentNeighboursOnly;
        this.tolerance = tolerance;
        rows = seatLayout.length;
        columns = seatLayout[0].length();
        positions = new Position[rows][columns];
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                char character = seatLayout[row].charAt(column);
                Position position;
                if(character == '.') {
                    position = new Position(false);
                } else if(character == 'L') {
                    position = new Position(true);
                } else {
                    throw new InvalidPuzzleInputException(
                        "Expected only '.' or 'L' during initialisation. Got '" + character + "' at column " + column + " row " + row);
                }
                positions[row][column] = position;
            }
        }
    }

    public boolean shift() {
        boolean changesMade = false;
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                if(shiftPositionIfRequired(row, column)) {
                    changesMade = true;
                }
            }
        }
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                positions[row][column].shift();
            }
        }
        return changesMade;
    }

    private boolean shiftPositionIfRequired(int row, int column) {
        Position position = positions[row][column];
        if(position.isSeat()) {
            int occupiedNeighbours = countOccupiedNeighbours(row, column);
            if(!position.isOccupied() && occupiedNeighbours == 0) {
                position.setNextState(true);
                return true;
            } else if(position.isOccupied() && occupiedNeighbours >= tolerance) {
                position.setNextState(false);
                return true;
            }
        }
        return false;
    }

    public int countAllOccupied() {
        int count = 0;
        for(int row = 0; row < rows; row++) {
            for(int column = 0; column < columns; column++) {
                if(positions[row][column].isOccupied()) {
                    count++;
                }
            }
        }
        return count;
    }

    private int countOccupiedNeighbours(int row, int column) {
        List<Position> occupiedNeighbours;
        if(adjacentNeighboursOnly) {
            occupiedNeighbours = getAdjacentNeighbours(row, column);
        } else {
            occupiedNeighbours = getVisibleNeighbours(row, column);
        }
        int count = 0;
        for(Position position : occupiedNeighbours) {
            if(position.isOccupied()) {
                count++;
            }
        }
        return count;
    }

    private List<Position> getAdjacentNeighbours(int row, int column) {
        List<Position> neighbours = new LinkedList<>();
        for(int y = row-1; y <= row+1; y++) {
            if(y < 0 || y == rows) {
                continue;
            }
            for(int x = column-1; x <= column+1; x++) {
                if(x < 0 || x == columns || (x == column && y == row)) {
                    continue;
                }
                Position position = positions[y][x];
                if(position.isSeat()) {
                    neighbours.add(position);
                }
            }
        }
        return neighbours;
    }

    private List<Position> getVisibleNeighbours(int row, int column) {
        List<Position> neighbours = new LinkedList<>();
        neighbours.add(findVisibleNeighboursAbove(row, column));
        neighbours.add(findVisibleNeighboursBelow(row, column));
        neighbours.add(findVisibleNeighboursLeft(row, column));
        neighbours.add(findVisibleNeighboursRight(row, column));
        neighbours.add(findVisibleNeighboursAboveLeft(row, column));
        neighbours.add(findVisibleNeighboursAboveRight(row, column));
        neighbours.add(findVisibleNeighboursBelowLeft(row, column));
        neighbours.add(findVisibleNeighboursBelowRight(row, column));
        while(neighbours.contains(null)) {
            neighbours.remove(null);
        }
        return neighbours;
    }

    private Position findVisibleNeighboursAbove(int row, int column) {
        for(int i = 1; i <= row; i++) {
            Position position = positions[row-i][column];
            if(position.isSeat()) {
                return position;
            }
        }
        return null;
    }

    private Position findVisibleNeighboursBelow(int row, int column) {
        for(int i = 1; i <= rows-row-1; i++) {
            Position position = positions[row+i][column];
            if(position.isSeat()) {
                return position;
            }
        }
        return null;
    }

    private Position findVisibleNeighboursLeft(int row, int column) {
        for(int i = 1; i <= column; i++) {
            Position position = positions[row][column-i];
            if(position.isSeat()) {
                return position;
            }
        }
        return null;
    }

    private Position findVisibleNeighboursRight(int row, int column) {
        for(int i = 1; i <= columns-column-1; i++) {
            Position position = positions[row][column+i];
            if(position.isSeat()) {
                return position;
            }
        }
        return null;
    }

    private Position findVisibleNeighboursAboveLeft(int row, int column) {
        for(int i = 1; i <= smallestOf(row, column); i++) {
            Position position = positions[row-i][column-i];
            if(position.isSeat()) {
                return position;
            }
        }
        return null;
    }

    private Position findVisibleNeighboursAboveRight(int row, int column) {
        for(int i = 1; i <= smallestOf(row, columns-column-1); i++) {
            Position position = positions[row-i][column+i];
            if(position.isSeat()) {
                return position;
            }
        }
        return null;
    }

    private Position findVisibleNeighboursBelowLeft(int row, int column) {
        for(int i = 1; i <= smallestOf(rows-row-1, column); i++) {
            Position position = positions[row+i][column-i];
            if(position.isSeat()) {
                return position;
            }
        }
        return null;
    }

    private Position findVisibleNeighboursBelowRight(int row, int column) {
        for(int i = 1; i <= smallestOf(rows-row, columns-column)-1; i++) {
            Position position = positions[row+i][column+i];
            if(position.isSeat()) {
                return position;
            }
        }
        return null;
    }
}