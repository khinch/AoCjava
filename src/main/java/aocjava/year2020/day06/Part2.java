package aocjava.year2020.day06;

import aocjava.Solvable;

import java.util.*;

public class Part2 implements Solvable {

    public String solve(String input) {
        int sum = 0;
        for(String groupAnswers : input.split("\n\n")) {
            sum += sumGroupPositives(groupAnswers);
        }
        return Integer.toString(sum);
    }

    private int sumGroupPositives(String groupAnswers) {
        String[] answerStrings = groupAnswers.split("\n");
        String firstAnswer = answerStrings[0];
        if(answerStrings.length == 1) {
            return firstAnswer.length();
        }
        char[] initialAnswers = firstAnswer.toCharArray();
        List<Character> commonAnswers = new LinkedList<>();
        for(Character character : initialAnswers) {
            commonAnswers.add(character);
        }
        for(int i = 1; i < answerStrings.length; i++) {
            for(Character answer : initialAnswers) {
                if(answerStrings[i].indexOf(answer) == -1) {
                    commonAnswers.remove(answer);
                }
            }
        }
        return commonAnswers.size();
    }
}