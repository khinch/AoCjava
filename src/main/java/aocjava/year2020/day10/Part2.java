package aocjava.year2020.day10;

import aocjava.InvalidPuzzleInputException;
import aocjava.Solvable;

import java.util.*;

public class Part2 implements Solvable {

    private static final int RATING = 3;
    private final List<Integer> adapters = new ArrayList<>();
    private Map<Integer, Long> pathsToHome = new HashMap<>();

    public String solve(String input) {
        for(String adaptorString : input.split("\n")) {
            adapters.add(Integer.parseInt(adaptorString));
        }
        adapters.add(0);
        pathsToHome.put(0, 1L);
        Collections.sort(adapters);

        for(int n = 1; n < adapters.size(); n++) {
            long paths = getAggregatedPreviousPaths(n);
            pathsToHome.put(n, paths);
        }

        return Long.toString(pathsToHome.get(pathsToHome.size()-1));
    }

    private List<Integer> getLinked(int index) {
        int adapterRating = adapters.get(index);
        List<Integer> linked = new LinkedList<>();
        for(int i = 1; i <= RATING; i++) {
            int previousIndex = index-i;
            if(previousIndex >= 0) {
                int previousRating = adapters.get(previousIndex);
                if(adapterRating - previousRating <= RATING) {
                    linked.add(previousIndex);
                }
            }
        }
        if(linked.isEmpty()) {
            throw new InvalidPuzzleInputException("Difference greater than the rating found between nearest numbers: " + adapterRating);
        }
        return linked;
    }

    private long getAggregatedPreviousPaths(int index) {
        long count = 0;
        for(int adapterIndex : getLinked(index)) {
            count += pathsToHome.get(adapterIndex);
        }
        return count;
    }
}