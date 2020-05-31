package app;

import command.CleanCommand;
import command.Command;
import commandparser.CommandParser;
import console.ConsoleWriter;
import model.DBContainer;

import java.util.Scanner;

public class Console
{
    private ConsoleWriter writer;
    private CommandParser commandParser;
    private Scanner input;
    private String stringCommand;

    public Console()
    {
        DBContainer container = new DBContainer();
        stringCommand = "";

        input = new Scanner(System.in);
        writer = new ConsoleWriter(System.out);
        commandParser = new CommandParser(writer, container);
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
           command.execute();
        }
        while(!stringCommand.equals("exit"));
    }
}