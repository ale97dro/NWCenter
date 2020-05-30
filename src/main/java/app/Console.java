package app;

import command.CleanCommand;
import commandparser.CommandParser;
import console.ConsoleWriter;

import java.util.Scanner;

public class Console
{
    public static void console()
    {
        //ProcessBuilder pb = new ProcessBuilder("clear");
        //Process process = Runtime.getRuntime().exec("clear");

        ConsoleWriter writer = new ConsoleWriter(System.out);

        new CleanCommand(writer).execute();

        String stringCommand = "";
        Scanner input = new Scanner(System.in);
        CommandParser commandParser = new CommandParser(writer);

        do
        {
            writer.print("NWC > ");
            stringCommand = input.nextLine();

            commandParser.parse(stringCommand).execute();


            //command.execute();
        }
        while(!stringCommand.equals("exit"));


        writer.println("Closing NW Center...");
    }
}
