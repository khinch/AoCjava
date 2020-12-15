package aocjava.utils;

import java.util.Arrays;

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

    @SuppressWarnings("java:S3012")
    public static long lowestCommonDenominator(Long[] numbers) {
        long[] sameNumbers = new long[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            sameNumbers[i] = numbers[i];
        }
        return lowestCommonDenominator(sameNumbers);
    }

    public static long lowestCommonDenominator(long... numbers) {
        if(numbers.length == 0) {
            return 0;
        } else if(numbers.length == 1) {
            return numbers[0];
        }
        Arrays.sort(numbers);
        long commonFactor = numbers[0];
        for(int i = 0; i < numbers.length-1; i++) {
            commonFactor = lowestCommonDenom(commonFactor, numbers[i+1]);
        }
        return commonFactor;
    }

    private static long lowestCommonDenom(long smaller, long larger) {
        boolean found = false;
        long factor = 0;
        while(!found) {
            factor += smaller;
            if(factor % larger == 0) {
                found = true;
            }
        }
        return factor;
    }
}
