package aocjava.year2017.day04;

public class Passphrase implements SelfValdation
{
    private String phrase;

    public Passphrase(String phrase)
    {
        this.phrase = phrase;
    }

    public boolean isValid()
    {
        String[] expressions = phrase.split("\\s");
        for (int i = 0; i < expressions.length - 1; i++)
        {
            for (int j = i + 1; j < expressions.length; j++)
            {
                if (expressions[i].equals(expressions[j]))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
