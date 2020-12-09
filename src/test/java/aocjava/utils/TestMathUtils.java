package aocjava.utils;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class TestMathUtils {

    @Test
    public void biggestOf() {
        assertEquals(1, MathUtils.biggestOf(1));
        assertEquals(2, MathUtils.biggestOf(2, 1));
        assertEquals(101, MathUtils.biggestOf(2, 101, -102));
        assertEquals(Integer.MAX_VALUE, MathUtils.biggestOf(101, Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertEquals(1L, MathUtils.biggestOf(1L));
        assertEquals(2L, MathUtils.biggestOf(2L, 1L));
        assertEquals(101L, MathUtils.biggestOf(2L, 101L, -102L));
        assertEquals(Long.MAX_VALUE, MathUtils.biggestOf(101L, Long.MIN_VALUE, Long.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, MathUtils.biggestOf(101L, Long.MIN_VALUE, Integer.MAX_VALUE));
    }

    @Test
    public void smallestOf() {
        assertEquals(1, MathUtils.smallestOf(1));
        assertEquals(1, MathUtils.smallestOf(2, 1));
        assertEquals(-102, MathUtils.smallestOf(2, 101, -102));
        assertEquals(Integer.MIN_VALUE, MathUtils.smallestOf(101, Integer.MIN_VALUE, Integer.MAX_VALUE));
        assertEquals(1L, MathUtils.smallestOf(1L));
        assertEquals(1L, MathUtils.smallestOf(2L, 1L));
        assertEquals(-102L, MathUtils.smallestOf(2L, 101L, -102L));
        assertEquals(Long.MIN_VALUE, MathUtils.smallestOf(101L, Long.MIN_VALUE, Long.MAX_VALUE));
        assertEquals(Integer.MIN_VALUE, MathUtils.smallestOf(101L, Integer.MIN_VALUE, Long.MAX_VALUE));
    }
}
