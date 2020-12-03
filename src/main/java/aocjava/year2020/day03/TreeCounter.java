package aocjava.year2020.day03;

public class TreeCounter {

    private TreeCounter(){}

    private static final char TREE = '#';
    static int countTrees(String[] lines, int xIncrement, int yIncrement) {
        int width = lines[0].length();
        int xPosition = 0;
        int trees = 0;

        for(int y = 0; y < lines.length; y += yIncrement) {
            int position = xPosition % width;
            if(lines[y].charAt(position) == TREE) {
                trees++;
            }
            xPosition += xIncrement;
        }
        return trees;
    }
}