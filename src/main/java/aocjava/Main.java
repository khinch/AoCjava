package aocjava;

import aocjava.cli.CliManager;
import aocjava.cli.UnexpectedActionException;
import aocjava.utils.ClasspathUtils;
import com.beust.jcommander.ParameterException;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

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
                doFileStuff(cliManager.getFile().getFilepath());
                break;
            case SOLVE:
                solveSingle(cliManager.getSolve().getYear(),
                        cliManager.getSolve().getDay(),
                        cliManager.getSolve().getPart(),
                        cliManager.getSolve().getInput());
                break;
            default:
                throw new UnexpectedActionException("Expected one of: help, show completed, file, solve.\n" +
                        "This is an internal error.");
        }
    }

    private static void showCompleted() {
        System.out.println("Completed solutions: \n");
        for(int year = 2015; year <= LocalDate.now().getYear(); year++) {
            List<String> puzzles = new LinkedList<>();
            for(int day = 1; day <= 25; day ++) {

                String puzzle;
                // if( part 1 completd) {
              // make string
              // if(part2 completed {
                // append string
              //}
            //}

                for(int part = 1; part <= 2; part++) {
                    if(ClasspathUtils.isClass(getSolvableClasspath(year, day, part))) {
                        puzzles.add(String.format("%02d", day) + " part " + part);
                    }
                }
            }
            if(!puzzles.isEmpty()) {
                System.out.println("\t" + year + ":");
                for(String puzzle : puzzles) {
                    System.out.println("\t\t" + puzzle);
                }
            }
        }
    }

    private static void doFileStuff(File filepathj) {
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

    private static void solveSingle(String year, String day, String part, String input) {
        String clazzpath = getSolvableClasspath(year, day, part);
        String puzzleId = year + "/" + day + "_part" + part;
        Solvable solvable = null;
        try{
            solvable = ClasspathUtils.getSolvable(clazzpath);
        } catch (ClassNotFoundException e) {
            System.out.println("No completed solution for " + puzzleId);
            System.exit(2);
        } catch (Exception e) {
            System.out.println("Unexpected exception occurred: " + e.toString());
            System.exit(3);
        }
        System.out.println("Solution for " + puzzleId + ": " + solvable.solve(input));
    }

    private static String getSolvableClasspath(int year, int day, int part) {
        return getSolvableClasspath(Integer.toString(year), String.format("%02d", day), Integer.toString(part));
    }

    private static String getSolvableClasspath(String year, String day, String part) {
        return "aocjava.year" + year + ".day" + day + ".Part" + part;
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
