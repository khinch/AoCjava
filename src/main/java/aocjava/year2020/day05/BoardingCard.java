package aocjava.year2020.day05;

public class BoardingCard {

    public static int calculateId(String code) {
        validateCode(code);
        return (calculateRow(code) * 8) + calculateColumn(code);
    }

    private static int calculateRow(String code) {
        int row = 0;
        int weight = 1;
        for(int i = 6; i >= 0; i--) {
            if(code.charAt(i) == 'B') {
                row += weight;
            }
            weight *= 2;
        }
        return row;
    }

    private static int calculateColumn(String code) {
        int column = 0;
        int weight = 1;
        for(int i = 9; i >= 7; i--) {
            if(code.charAt(i) == 'R') {
                column += weight;
            }
            weight *= 2;
        }
        return column;
    }

    private static void validateCode(String code) {
        // TODO throw exception if code is invalid [BF]{7}[RL]{3}
    }

}
