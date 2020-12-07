package aocjava.year2020.day07;

import java.util.HashMap;
import java.util.Map;

public class Rule {

    private final Map<String, Integer> contents = new HashMap<>();

    public Rule() {}

    public void addContent(String colour, int amount) {
        if(contents.containsKey(colour)) {
            contents.put(colour, amount + contents.get(colour));
        } else {
            contents.put(colour,amount);
        }
    }

    public Map<String, Integer> getContents() {
        return contents;
    }

    public boolean contains(String colour) {
        return contents.containsKey(colour);
    }
}
