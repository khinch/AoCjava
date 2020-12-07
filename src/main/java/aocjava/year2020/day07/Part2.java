package aocjava.year2020.day07;

import aocjava.Solvable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Part2 implements Solvable {

    private final Map<String, Rule> rules = new HashMap<>();
    private final Set<String> colours = new HashSet<>();
    private static final String TARGET_COLOUR = "shiny gold";

    public String solve(String input) {
        for(String rule : input.split("\n")) {
            parseRule(rule);
        }

//        List<String> containersOfTarget = new LinkedList<>();
//        for(String topLevelContainer : getTopLevelContainers()) {
//            if(getAllContainedColours(topLevelContainer).contains(TARGET_COLOUR)) {
//                containersOfTarget.add(topLevelContainer);
//            }
//        }
//
//        return Integer.toString(containersOfTarget.size());

//        System.out.println("dotted black: " + getAllContainedColours("dotted black"));
//        System.out.println("faded blue: " + getAllContainedColours("faded blue"));
//        System.out.println("dark olive: " + getAllContainedColours("dark olive"));
//        System.out.println("vibrant plum: " + getAllContainedColours("vibrant plum"));
//        System.out.println("shiny gold: " + getAllContainedColours("shiny gold"));
//        System.out.println("muted yellow: " + getAllContainedColours("muted yellow"));
//        System.out.println("bright white: " + getAllContainedColours("bright white"));
//        System.out.println("light red: " + getAllContainedColours("light red"));
//        System.out.println("dark orange: " + getAllContainedColours("dark orange"));


//        Set<String> containers = new HashSet<>();
//        for(String colour : colours) {
//            if(getAllContainedColours(colour).contains(TARGET_COLOUR)) {
//                containers.add(colour);
//            }
//        }

        return Integer.toString(countAllContainedBags("shiny gold"));
    }

    private void parseRule(String ruleString) {
        // TODO fix names
        Rule rule = new Rule();
        String[] bob = ruleString.split(" bags contain ");
        String container = bob[0];
        colours.add(container);
        String contained = bob[1];
        if(!contained.contains("no other bags")) {
            for(String bertha : contained.split(", ")) {
                String[] zoomer = bertha.split(" ");
                String containedColour = zoomer[1] + " " + zoomer[2];
                colours.add(containedColour);
                rule.addContent(containedColour, Integer.parseInt(zoomer[0]));
            }
        }
        rules.put(container, rule);
    }

    private Set<String> getTopLevelContainers() {
        Set<String> topLevelContainers = new HashSet<>();
        topLevelContainers.addAll(rules.keySet());
        for(String container : rules.keySet()) {
            for(String contained : rules.get(container).getContents().keySet()) {
                if(topLevelContainers.contains(contained)) {
                    topLevelContainers.remove(contained);
                }
            }
        }
        return topLevelContainers;
    }

    private Set<String> getContainedColours(String colour) {
        return rules.get(colour).getContents().keySet();

    }

    private Set<String> getAllContainedColours(String colour) {
        Set<String> contains = new HashSet<>();

        for(String containedColour : getContainedColours(colour)) {
            contains.add(containedColour);
            Set<String> innerContents = getContainedColours(containedColour);
            if(!innerContents.isEmpty()) {
                for(String containedInnerColour : getAllContainedColours(containedColour)) {
                    contains.add(containedInnerColour);
                }
            }
        }

        return contains;
    }

    private int countAllContainedBags(String colour) {
        int count = 0;

        for(String containedColour : getContainedColours(colour)) {
            int colourCount = rules.get(colour).getContents().get(containedColour);
            count += colourCount;

            for(int i = 0; i < colourCount; i++) {
                count += countAllContainedBags(containedColour);

            }




            // Set<String> innerContents = getContainedColours(containedColour);
//            if(!innerContents.isEmpty()) {
//                for(String containedInnerColour : getAllContainedColours(containedColour)) {
//                    count++;
//                }
//            }
        }

        return count;
    }

}
