package aocjava.utils;

public class MathUtils {

    private MathUtils(){}

    public static long biggestOf(long... numbers) {
        long biggest = numbers[0];
        if(numbers.length > 1) {
            for(int i = 1; i < numbers.length; i++) {
                if(numbers[i] > biggest) {
                    biggest = numbers[i];
                }
            }
        }
        return biggest;
    }

    public static int biggestOf(int... numbers) {
        int biggest = numbers[0];
        if(numbers.length > 1) {
            for(int i = 1; i < numbers.length; i++) {
                if(numbers[i] > biggest) {
                    biggest = numbers[i];
                }
            }
        }
        return biggest;
    }

    public static long smallestOf(long... numbers) {
        long smallest = numbers[0];
        if(numbers.length > 1) {
            for(int i = 1; i < numbers.length; i++) {
                if(numbers[i] < smallest) {
                    smallest = numbers[i];
                }
            }
        }
        return smallest;
    }

    public static int smallestOf(int... numbers) {
        int smallest = numbers[0];
        if(numbers.length > 1) {
            for(int i = 1; i < numbers.length; i++) {
                if(numbers[i] < smallest) {
                    smallest = numbers[i];
                }
            }
        }
        return smallest;
    }
}
