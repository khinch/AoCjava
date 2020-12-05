package aocjava.year2020.day05;

import aocjava.ResolutionFailureException;
import aocjava.Solvable;

import java.util.HashSet;
import java.util.Set;

public class Part2 implements Solvable {

    public String solve(String input) {
        Set<Integer> emptySeats = new HashSet<>();
        for(int i = 0; i < 1024; i++) {
            emptySeats.add(i);
        }
        for(String boardingCardString : input.split("\n")) {
            emptySeats.remove(BoardingCard.calculateId(boardingCardString));
        }
        for(int seat : emptySeats) {
            if(!(emptySeats.contains(seat-1) || emptySeats.contains(seat+1))) {
                return Integer.toString(seat);
            }
        }
        throw new ResolutionFailureException("Failed to find solution");
    }
}