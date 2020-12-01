package aocjava.jcommander;

public class NonExistentPuzzleException extends RuntimeException {
    NonExistentPuzzleException(String message) {
        super(message);
    }
}
