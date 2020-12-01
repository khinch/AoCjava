package aocjava.jcommander;

public class PuzzleNotSolvedException extends RuntimeException{
    PuzzleNotSolvedException(String message) {
        super(message);
    }
}
