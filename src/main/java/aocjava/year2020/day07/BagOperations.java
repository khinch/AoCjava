package aocjava.year2020.day07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class BagOperations {

    private final Map<String, Rule> rules = new HashMap<>();
    private final Set<String> colours = new HashSet<>();

    BagOperations(String... ruleStrings) {
        for(String ruleString : ruleStrings) {
            addRule(ruleString);
        }
    }

    private void addRule(String ruleString) {
        Rule rule = new Rule();
        String[] ruleKeyValues = ruleString.split(" bags contain ");
        String ruleKey = ruleKeyValues[0];
        colours.add(ruleKey);
        String ruleValues = ruleKeyValues[1];
        if(!ruleValues.contains("no other bags")) {
            for(String ruleValue : ruleValues.split(", ")) {
                String[] colourAndCount = ruleValue.split(" ");
                String containedColour = colourAndCount[1] + " " + colourAndCount[2];
                colours.add(containedColour);
                rule.bagColour(containedColour, Integer.parseInt(colourAndCount[0]));
            }
        }
        rules.put(ruleKey, rule);
    }

    public Set<String> getContainersOf(String bagColour) {
        Set<String> containers = new HashSet<>();
        for(String colour : colours) {
            if(getAllContainedColours(colour).contains(bagColour)) {
                containers.add(colour);
            }
        }
        return containers;
    }

    public int countAllContainedBags(String bagColour) {
        int count = 0;
        Rule rule = rules.get(bagColour);
        for(String innerBagColour : rule.getInnerColours()) {
            int innerBagCount = rule.getContainedCount(innerBagColour);
            count += innerBagCount;
            for(int i = 0; i < innerBagCount; i++) {
                count += countAllContainedBags(innerBagColour);
            }
        }
        return count;
    }

    private Set<String> getAllContainedColours(String bagColour) {
        Set<String> allContents = new HashSet<>();
        Rule rule = rules.get(bagColour);
        for(String innerBagColour : rule.getInnerColours()) {
            allContents.add(innerBagColour);
            Set<String> innerContents = rules.get(innerBagColour).getInnerColours();
            if(!innerContents.isEmpty()) {
                allContents.addAll(getAllContainedColours(innerBagColour));
            }
        }
        return allContents;
    }
}