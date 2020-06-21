/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package app;

import command.ClearCommand;
import command.Command;
import commandparser.CommandParser;
import console.ConsolePrinter;
import formatter.Formatter;
import model.DBContainer;
import model.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Container to simulate a command-line console.
 * It provides a loop in which user can perform his tasks
 *
 * @author Alessandro Bianchi
 */
public class Console
{
    private static final String EXIT_COMMAND = "exit";
    private ConsolePrinter printer;
    private CommandParser commandParser;
    private Scanner input;
    private String stringCommand;
    private Environment environment;

    /**
     * Public constructor for Console
     * Instance Java scanner, {@link model.DBContainer}, history, {@link commandparser.CommandParser} and the {@link model.Environment}
     */
    public Console()
    {
        stringCommand = "";
        input = new Scanner(System.in);

        DBContainer container = new DBContainer();
        printer = new ConsolePrinter(System.out);
        List<String> history = new ArrayList<>();
        environment = new Environment(container, history, System.getProperty("os.name"));
        commandParser = new CommandParser(environment);
    }

    /**
     * Provides the loop to perform tasks.
     * This method calls a parser that create the command you want to perform.
     */
    public void console()
    {
        //ProcessBuilder pb = new ProcessBuilder("clear");
        //Process process = Runtime.getRuntime().exec("clear");

        new ClearCommand(environment.getOs()).execute();

        do
        {
            printer.print("NWC > ");
            stringCommand = input.nextLine();

           Command command = commandParser.parse(stringCommand);

           if(command != null)
           {
               Formatter formatter = command.execute();
               if(formatter != null)
                println(formatter.format());
           }
        }
        while(!stringCommand.equals(EXIT_COMMAND));
    }

    /**
     * Print something on the console
     * @param result List of strings you want to print
     */
    private void println(List<String> result)
    {
        for(String s : result)
            printer.print(s);
    }
}