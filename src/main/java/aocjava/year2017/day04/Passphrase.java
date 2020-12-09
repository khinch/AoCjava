package aocjava.year2017.day04;

import aocjava.utils.SelfValdation;
import aocjava.utils.StringUtils;

public class Passphrase implements SelfValdation
{
    private String phrase;
    private Validator validator;

    public enum Validator{EQUALITY, ANAGRAM}

    Passphrase(String phrase, Validator validator)
    {
        this.phrase = phrase;
        this.validator = validator;
    }

    public boolean isValid() throws Exception
    {
        String[] expressions = phrase.split("\\s");
        for (int i = 0; i < expressions.length - 1; i++)
        {
            for (int j = i + 1; j < expressions.length; j++)
            {
                switch (validator)
                {
                    case EQUALITY:  if (expressions[i].equals(expressions[j]))
                        {
                            return false;
                        }
                        break;
                    case ANAGRAM:  if (StringUtils.isAnagram(expressions[i], expressions[j], true))
                        {
                            return false;
                        }
                        break;
                    default: throw new Exception("Unknown validation type: " + validator.toString()); // This should be unreachable
                }
            }
        }
        return true;
    }
}