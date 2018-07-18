package aocjava;

public class Clue
{
    private String input;
    private String expectedOutput;

    private Clue(){}

    public Clue(String input, String expectedOutput)
    {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    public String getInput()
    {
        return input;
    }

    public String getExpectedOutput()
    {
        return expectedOutput;
    }
}
