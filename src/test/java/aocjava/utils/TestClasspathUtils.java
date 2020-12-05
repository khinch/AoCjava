package aocjava.utils;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestClasspathUtils {

    @Test
    static void testIsClass() {
        assertTrue(ClasspathUtils.isClass("aocjava.Main"));
        assertTrue(ClasspathUtils.isClass("aocjava.utils.ClasspathUtils"));
        assertTrue(ClasspathUtils.isClass("aocjava.utils.TestClasspathUtils"));
        assertFalse(ClasspathUtils.isClass("aocjava.nonexistentpath"));
    }
}
