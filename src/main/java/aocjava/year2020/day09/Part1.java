package aocjava.year2020.day09;

import aocjava.ResolutionFailureException;
import aocjava.Solvable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Part1 implements Solvable {

    private final int preamble;

    public Part1(int preamble) {
        this.preamble = preamble;
    }

    public String solve(String input) {
        String[] entryStrings = input.split("\n");
        Long[] values = new Long[entryStrings.length];
        for(int i = 0; i < entryStrings.length; i++) {
            values[i] = Long.parseLong(entryStrings[i]);
        }
        List<List<Long>> sums = new LinkedList<>();

        // populate preamble sums
        for(int i = 0; i < preamble-1; i++) {
            List<Long> indexSums = new ArrayList<>();
            for(int j = i+1; j < preamble; j++) {
                indexSums.add(values[i] + values[j]);
            }
            sums.add(indexSums);
        }

        // begin validation from preamble+1
        for(int v = preamble; v < values.length; v++) {
            // Validate number by checking the pre-calculated sums, and return it if invalid
            Long valueInFocus = values[v];
            boolean valid = false;
            for(int i = 0; i < preamble-1; i++) {
                if(sums.get(i).contains(valueInFocus)) {
                    valid = true;
                    break;
                }
            }
            if(!valid) {
                return valueInFocus.toString();
            }

            // List of sums at v-preamble now becomes useless, remove them from the list
            sums.remove(0);

            // Create a new list for v-1 (containing sum of number plus previous), and then iterate over the remaining
            // three previous lists to add the new sum
            List<Long> indexSums = new ArrayList<>();
            indexSums.add(valueInFocus + values[v-1]);
            sums.add(indexSums);
            for(int i = 0; i < preamble-2; i++) {
                sums.get(i).add(valueInFocus + values[v-preamble+(i+1)]);
            }

        }
        throw new ResolutionFailureException("Failed to find an invalid number in the list");
    }

}