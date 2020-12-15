package aocjava.utils;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestMathUtils {

    @Test
    public void biggestOf() {
        assertEquals(MathUtils.biggestOf(1), 1);
        assertEquals(MathUtils.biggestOf(2, 1), 2);
        assertEquals(MathUtils.biggestOf(2, 101, -102), 101);
        assertEquals(MathUtils.biggestOf(101, Integer.MIN_VALUE, Integer.MAX_VALUE), Integer.MAX_VALUE);
        assertEquals(MathUtils.biggestOf(1L), 1L);
        assertEquals(MathUtils.biggestOf(2L, 1L), 2L);
        assertEquals(MathUtils.biggestOf(2L, 101L, -102L), 101L);
        assertEquals(MathUtils.biggestOf(101L, Long.MIN_VALUE, Long.MAX_VALUE), Long.MAX_VALUE);
        assertEquals(MathUtils.biggestOf(101L, Long.MIN_VALUE, Integer.MAX_VALUE), Integer.MAX_VALUE);
    }

    @Test
    public void smallestOf() {
        assertEquals(MathUtils.smallestOf(1), 1);
        assertEquals(MathUtils.smallestOf(2, 1),1);
        assertEquals(MathUtils.smallestOf(2, 101, -102), -102);
        assertEquals(MathUtils.smallestOf(101, Integer.MIN_VALUE, Integer.MAX_VALUE), Integer.MIN_VALUE);
        assertEquals(MathUtils.smallestOf(1L), 1L);
        assertEquals(MathUtils.smallestOf(2L, 1L), 1L);
        assertEquals(MathUtils.smallestOf(2L, 101L, -102L), -102L);
        assertEquals(MathUtils.smallestOf(101L, Long.MIN_VALUE, Long.MAX_VALUE), Long.MIN_VALUE);
        assertEquals(MathUtils.smallestOf(101L, Integer.MIN_VALUE, Long.MAX_VALUE), Integer.MIN_VALUE);
    }

    @Test
    public void lowestCommonDenominator() {
        assertEquals(MathUtils.lowestCommonDenominator(), 0);
        assertEquals(MathUtils.lowestCommonDenominator(1), 1);
        assertEquals(MathUtils.lowestCommonDenominator(3, 4), 12);
        assertEquals(MathUtils.lowestCommonDenominator(4, 3), 12);
        assertEquals(MathUtils.lowestCommonDenominator(4, 11, 17), 748);
        assertEquals(MathUtils.lowestCommonDenominator(17, 4, 11), 748);
        assertEquals(MathUtils.lowestCommonDenominator(new Long[] {17L, 4L, 11L}), 748);
    }

}
