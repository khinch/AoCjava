package aocjava.year2020.day13;

import aocjava.BaseTest;
import aocjava.Clue;
import org.testng.annotations.Test;

public class Tests extends BaseTest {

    @Test
    public void part1() {
        testClue(new Part1(), new Clue("939\n7,13,x,x,59,x,31,19", "295"));
    }

//    @Test
//    public void part2() {
//        Part2 part2 = new Part2();
//        testClue(part2, new Clue("\n6,13","12"));
//        testClue(part2, new Clue("\n17,x,13,19","3417"));
//        testClue(part2, new Clue("\n67,7,59,61","754018"));
//        testClue(part2, new Clue("\n67,x,7,59,61","779210"));
//        testClue(part2, new Clue("\n17,x,13,19","3417"));
//        testClue(part2, new Clue("\n67,7,x,59,61","1261476"));
//        testClue(part2, new Clue("\n1789,37,47,1889","1202161486"));
//    }
}
