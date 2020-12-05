package aocjava;

import aocjava.cli.CliManager;
import aocjava.cli.UnexpectedActionException;
import aocjava.cli.jcommander.Solve;
import aocjava.utils.ClasspathUtils;
import com.beust.jcommander.ParameterException;
import java.lang.reflect.InvocationTargetException;

public class Main
{
    public static void main(String... args) {

        CliManager cliManager = new CliManager(args, "AoCjava");
        try {
            cliManager.validateCliArgs();
        } catch (ParameterException e) {
            System.out.println("Failed to validate arguments: " + e.getMessage());
            cliManager.printUsage();
            System.exit(1);
        }

        switch (cliManager.getAction()) {
            case HELP:
                cliManager.showHelp();
                break;
            case SHOWCOMPLETED:
                showCompleted();
                break;
            case FILE:
                doFileStuff();
                break;
            case SOLVE:
                solveSingle(cliManager.getSolve());
                break;
            default:
                throw new UnexpectedActionException("Expected one of: help, show completed, file, solve.\n" +
                        "This is an internal error.");
        }
    }

    private static void showCompleted() {
        System.out.println("Showing all completed solutions");
        // use reflection to loop through classes that implement Solvable interface
    }

    private static void doFileStuff() {
        System.out.println("Doing file stuff");
        // get file path
        // check file exists
        // validate against schema
        // pass it to something to deal with it


        //        if(jCommander.getParsedCommand().equals("file")) {
//            if(!file.getFilepath().exists()) {
//                return false;
//            }
//            // validate against schema
//        }

    }

    private static void solveSingle(Solve solve) {
        String year = solve.getYear();
        String day = solve.getDay();
        String part = solve.getPart();
        String input = solve.getInput();

        String clazzpath = "aocjava.year" + year + ".day" + day + ".Part" + part;

        Solvable solvable = ClasspathUtils.getSolvable(clazzpath);
        System.out.println(solvable.solve(input));




        // System.out.println("Doing solve stuff");
        // get details of what to run
        // pass it to something to deal with it
    }

    private static void reflectionStuff() {
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
        if (myGoodObject instanceof Solvable) {
            System.out.println("We're good to go!");
        } else {
            System.out.println("D'oh!");
        }
//        Solvable goodSolvable = (Solvable)myGoodObject;
//        Solvable badSolvable = (Solvable)myBadObject;
    }




}
