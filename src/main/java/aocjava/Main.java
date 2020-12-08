package aocjava;

import aocjava.cli.CliManager;
import aocjava.cli.SchemaValidator;
import aocjava.cli.UnexpectedActionException;
import aocjava.utils.ClasspathUtils;
import com.beust.jcommander.ParameterException;
import org.everit.json.schema.ValidationException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main
{
    public static void main(String... args) throws Exception {

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
                        cliManager.getSolve().getInput()); // TODO refactor cliManager to use custom solve object
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
                if(ClasspathUtils.isClass(getSolvableClasspath(year, day, 1))) {
                    puzzle = String.format("%02d", day) + " part 1";
                    if(ClasspathUtils.isClass(getSolvableClasspath(year, day, 2))) {
                        puzzle = puzzle + " & 2";
                    }
                    puzzles.add(puzzle);
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

    private static void doFileStuff(File filepath) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(filepath);
        JSONTokener jsonTokener = new JSONTokener(fileInputStream);
        JSONObject jsonObject = new JSONObject(jsonTokener);
        SchemaValidator schemaValidator = new SchemaValidator("schema.json");
        try {
            schemaValidator.validate(jsonObject);
        } catch (ValidationException e) {
            System.out.println("Input file failed validation, please check format:\t");
            System.out.println("\t" + e.getMessage());
            System.out.println("\t" + filepath);
            System.out.println("\tValid years are 2015 onwards. Valid days are 1-25. Valid parts are 1 & 2.");
            System.out.println("\tExample format:");
            System.out.println("{\n" +
                    "  \"years\": [\n" +
                    "    {\n" +
                    "      \"year\": 2015,\n" +
                    "      \"days\": [\n" +
                    "        {\n" +
                    "          \"day\": 1,\n" +
                    "          \"parts\": [\n" +
                    "            {\n" +
                    "              \"part\": 1,\n" +
                    "              \"input\": \"Puzzle input here\"\n" +
                    "            }\n" +
                    "          ]\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    }\n" +
                    "  ]\n" +
                    "}");
        }

        Map<String, Object> objectList = jsonObject.toMap();
        // TODO these things:
        // Define a custom class to hold the params (also can be used for solveSingle)
        // Pass object list to a method to return a list of param objects
        // for each object in the list, call solveSingle(<Object>)
        // output answers for each solution, catch any exceptions and show the error messages

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

}