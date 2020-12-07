package aocjava.year2020.day07;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Rule {

    private final Map<String, Integer> contents = new HashMap<>();

    void bagColour(String colour, int amount) {
        if(contents.containsKey(colour)) {
            contents.put(colour, amount + contents.get(colour));
        } else {
            contents.put(colour,amount);
        }
    }

    Set<String> getInnerColours() {
        return contents.keySet();
    }

    int getContainedCount(String bagColour) {
        return contents.getOrDefault(bagColour, 0);
    }
}