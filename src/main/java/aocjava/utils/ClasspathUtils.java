package aocjava.utils;

import aocjava.Solvable;

import java.lang.reflect.InvocationTargetException;

public class ClasspathUtils {

    private ClasspathUtils(){}

    public static boolean isClass(String path) {
        try {
            Class.forName(path);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static Solvable getSolvable(String path) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        return (Solvable) Class.forName(path).getDeclaredConstructor().newInstance();
    }
}