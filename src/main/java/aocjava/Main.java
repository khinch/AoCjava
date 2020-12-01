package aocjava;

import aocjava.jcommander.File;
import aocjava.jcommander.Help;
import aocjava.jcommander.Solve;
import aocjava.jcommander.UnexpectedCommandException;
import com.beust.jcommander.JCommander;

public class Main
{
    public static void main(String... args)
    {
        Solve solve = new Solve();
        File file = new File();
        Help help = new Help();
        JCommander jCommander = JCommander.newBuilder()
                .addCommand("solve", solve)
                .addCommand("file", file)
                .addObject(help)
                .build();

        jCommander.setProgramName("AoCjava");
        jCommander.setCaseSensitiveOptions(false);

        jCommander.parse(args);

        if(help.isShowHelp()) {
            jCommander.usage();
        } else if(help.isShowCompleted()) {
            showCompleted();
        } else if(jCommander.getParsedCommand().equals("file")) {
            // do file stuff
            System.out.println(file.getFilepath());
        } else if(jCommander.getParsedCommand().equals("solve")) {
            // do solver stuff
            System.out.println(solve.getYear() + " " + solve.getDay() + " " + solve.getPart() + " " + solve.getInput());
        } else {
            throw new UnexpectedCommandException("No handler for command: " + jCommander.getParsedCommand());
        }
    }

    private static void showCompleted() {
        System.out.println("Showing all completed solutions");
    }


}
