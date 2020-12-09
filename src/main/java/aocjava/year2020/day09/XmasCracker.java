package aocjava.year2020.day09;

import aocjava.ResolutionFailureException;
import org.apache.commons.lang3.ArrayUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import static aocjava.utils.MathUtils.biggestOf;
import static aocjava.utils.MathUtils.smallestOf;

public class XmasCracker {

    private final int preamble;
    private final long[] values;
    private final List<List<Long>> sums = new LinkedList<>();

    public XmasCracker(int preambleSize, String... valueStrings) {
        this.preamble = preambleSize;
        this.values = new long[valueStrings.length];
        for(int i = 0; i < valueStrings.length; i++) {
            values[i] = Long.parseLong(valueStrings[i]);
        }
    }

    public long findWeakness() {
        long invalidEntry = findInvalidEntry();
        int startIndex = ArrayUtils.indexOf(values, invalidEntry)-1;
        // Start at the number before the invalid one in the array. If it's larger than the one we're looking for, move
        // down and try again. If it's smaller, but the previous one is larger, or the aggregate is larger, move down
        // and try again. When we find multiple contiguous numbers that aggregate to the exact value of the invalid
        // number, then sum the largest to the smallest and return.
        for(int y = startIndex; y > 0; y--) {
            long aggregate = values[y];
            if(aggregate > invalidEntry) {
                continue;
            }
            for(int x = y-1; x >= 0; x--) {
                long bob = values[x];
                if(bob > invalidEntry) {
                    break;
                }
                aggregate += bob;
                if(aggregate > invalidEntry) {
                    break;
                } else if(aggregate == invalidEntry) {
                    long[] contiguousSet = Arrays.copyOfRange(values, x, y+1);
                    return biggestOf(contiguousSet) + smallestOf(contiguousSet);
                }
            }
        }
        throw new ResolutionFailureException("Failed to find contiguous set.");
    }

    public long findInvalidEntry() {
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
            long valueInFocus = values[v];
            boolean valid = false;
            for(int i = 0; i < preamble-1; i++) {
                if(sums.get(i).contains(valueInFocus)) {
                    valid = true;
                    break;
                }
            }
            if(!valid) {
                return valueInFocus;
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
        return -1;
    }
}