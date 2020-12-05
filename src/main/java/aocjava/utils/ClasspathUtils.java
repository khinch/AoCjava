package aocjava.utils;

import aocjava.Solvable;

import java.lang.reflect.InvocationTargetException;

public class ClasspathUtils {

    private ClasspathUtils(){}

    public static boolean isClass(String path) {
        try {
            Class clazz = Class.forName(path);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static Solvable getSolvable(String path) {
        Class clazz = null;
        try {
            clazz = Class.forName(path);
        } catch (ClassNotFoundException e) {

        }
        Object object = null;
        try {
            object = clazz.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {

        }
        return (Solvable) object;
    }
}