package aocjava.year2020.day10;

import aocjava.InvalidPuzzleInputException;
import aocjava.Solvable;
import java.util.*;

public class Part2 implements Solvable {

    private static final int RATING = 3;
    private final List<Integer> adapters = new ArrayList<>();
    private final Map<Integer, Long> pathsFromOutlet = new HashMap<>();

    public String solve(String input) {
        for(String adaptorString : input.split("\n")) {
            adapters.add(Integer.parseInt(adaptorString));
        }
        adapters.add(0);
        pathsFromOutlet.put(0, 1L);
        Collections.sort(adapters);

        for(int n = 1; n < adapters.size(); n++) {
            long paths = getAggregatedPreviousPaths(n);
            pathsFromOutlet.put(n, paths);
        }
        return Long.toString(pathsFromOutlet.get(pathsFromOutlet.size()-1));
    }

    private List<Integer> getLinkedAdapters(int position) {
        int adapterRating = adapters.get(position);
        List<Integer> linkedAdapters = new LinkedList<>();
        for(int i = 1; i <= RATING; i++) {
            int previousIndex = position-i;
            if(previousIndex >= 0) {
                int previousAdapterRating = adapters.get(previousIndex);
                if(adapterRating - previousAdapterRating <= RATING) {
                    linkedAdapters.add(previousIndex);
                }
            }
        }
        if(linkedAdapters.isEmpty()) {
            throw new InvalidPuzzleInputException("Difference greater than the rating found between nearest numbers: " + adapterRating);
        }
        return linkedAdapters;
    }

    private long getAggregatedPreviousPaths(int position) {
        long count = 0;
        for(int adapterIndex : getLinkedAdapters(position)) {
            count += pathsFromOutlet.get(adapterIndex);
        }
        return count;
    }
}