package aocjava;

import aocjava.cli.*;

import java.lang.reflect.InvocationTargetException;

public class Main
{
    public static void main(String... args)
    {
        CliValidator validator = new CliValidator(args, "AoCjava");
        validator.validateCliArgs();

        String year = "2017";
        String day = "02";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("aocjava.year");
        stringBuilder.append(year);
        stringBuilder.append(".day");
        stringBuilder.append(day);
        stringBuilder.append(".Solve");
        String goodClassPath = stringBuilder.toString();
//        String goodClassPath = "aocjava.year2017.day01.Solve";
        String badClassPath = "aocjava.year2017.day02.Solve";

//        Object myGoodObject;
        Object myBadObject;
        Class myGoodClass = null;
        try {
//            myGoodObject = Class.forName(goodClassPath).getDeclaredConstructor().newInstance();
//            myBadObject = Class.forName(badClassPath).getDeclaredConstructor().newInstance();
            myGoodClass = Class.forName(goodClassPath);
        } catch (ClassNotFoundException e) {
            System.out.println("No such class: " + goodClassPath);
//            myGoodObject = new Object();
//            myBadObject = new Object();
        }
        Object myGoodObject = null;
        try {
            myGoodObject = myGoodClass.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Unable to initialise class: " + goodClassPath);
        }
        if(myGoodObject instanceof Solvable) {
            System.out.println("We're good to go!");
        } else {
            System.out.println("D'oh!");
        }
//        Solvable goodSolvable = (Solvable)myGoodObject;
//        Solvable badSolvable = (Solvable)myBadObject;

//        if(jCommander.getParsedCommand().equals("file")) {
//            if(!file.getFilepath().exists()) {
//                return false;
//            }
//            // validate against schema
//        }

    }

    private static void showCompleted() {
        System.out.println("Showing all completed solutions");
    }


}
