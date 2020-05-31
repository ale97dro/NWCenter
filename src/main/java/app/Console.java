package app;

import command.CleanCommand;
import command.Command;
import commandparser.CommandParser;
import console.ConsoleWriter;
import model.DBContainer;
import model.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console
{
    private ConsoleWriter writer;
    private CommandParser commandParser;
    private Scanner input;
    private String stringCommand;

    public Console()
    {
        stringCommand = "";
        input = new Scanner(System.in);

        DBContainer container = new DBContainer();
        writer = new ConsoleWriter(System.out);
        List<String> history = new ArrayList<>();
        Environment environment = new Environment(container, writer, history);
        commandParser = new CommandParser(environment);
    }

    public void console()
    {
        //ProcessBuilder pb = new ProcessBuilder("clear");
        //Process process = Runtime.getRuntime().exec("clear");

        new CleanCommand(writer).execute();

        do
        {
            writer.print("NWC > ");
            stringCommand = input.nextLine();

           Command command = commandParser.parse(stringCommand);

           if(command != null)
               command.execute();
        }
        while(!stringCommand.equals("exit"));
    }
}