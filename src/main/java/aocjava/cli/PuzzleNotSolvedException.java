package aocjava.cli;

public class PuzzleNotSolvedException extends RuntimeException{
    PuzzleNotSolvedException(String message) {
        super(message);
    }
}
