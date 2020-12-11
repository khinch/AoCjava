package aocjava.year2020.day11;

public class Position {

    private boolean occupied = false;
    private Boolean nextState = null;
    private final boolean seat;

    public Position(boolean seat) {
        this.seat = seat;
    }

    public boolean isSeat() {
        return seat;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setNextState(boolean state) {
        this.nextState = state;
    }

    public void shift() {
        if(nextState != null) {
            occupied = nextState;
        }
        nextState = null;
    }
}