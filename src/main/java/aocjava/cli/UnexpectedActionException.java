package aocjava.cli;

public class UnexpectedActionException extends RuntimeException {
    public UnexpectedActionException(String message) {
        super(message);
    }
}
