package aocjava.cli;

public class NonExistentPuzzleException extends RuntimeException {
    NonExistentPuzzleException(String message) {
        super(message);
    }
}
