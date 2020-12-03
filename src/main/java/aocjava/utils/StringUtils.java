package aocjava.utils;

import java.util.HashMap;

public class StringUtils
{
    public static boolean isAnagram(String word1, String word2, boolean caseSensitive)
    {
        if(!caseSensitive)
        {
            word1 = word1.toLowerCase();
            word2 = word2.toLowerCase();
        }

        if(word1.length() != word2.length())
        {
            return false;
        }

        HashMap<String, Integer> wordMap1 = characterMap(word1);
        HashMap<String, Integer> wordMap2 = characterMap(word2);

        for(String key : wordMap1.keySet())
        {
            if(wordMap1.get(key).equals(wordMap2.get(key)))
            {
                return false;
            }
        }

        return true;


    }

    private static HashMap<String, Integer> characterMap(String word)
    {
        HashMap<String, Integer> myMap = new HashMap<>();

        for(String s : word.split(""))
        {
            if(myMap.containsKey(s))
            {
                myMap.put(s, myMap.get(s) + 1);
            } else
            {
                myMap.put(s, 1);
            }
        }

        return myMap;
    }

}
