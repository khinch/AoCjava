package aocjava;

import static org.testng.Assert.assertEquals;

public abstract class BaseTest {
    public void testClue(Solvable part, Clue clue) {
        String input = clue.getInput();
        String expectedOutput = clue.getExpectedOutput();
        String actualOutput = part.solve(input);
        assertEquals(actualOutput, expectedOutput);
    }
}