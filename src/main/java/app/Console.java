/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package app;

import command.CleanCommand;
import command.Command;
import commandparser.CommandParser;
import console.ConsolePrinter;
import formatter.Formatter;
import model.DBContainer;
import model.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console
{
    private ConsolePrinter printer;
    private CommandParser commandParser;
    private Scanner input;
    private String stringCommand;

    public Console()
    {
        stringCommand = "";
        input = new Scanner(System.in);

        DBContainer container = new DBContainer();
        printer = new ConsolePrinter(System.out);
        List<String> history = new ArrayList<>();
        Environment environment = new Environment(container, history);
        commandParser = new CommandParser(environment);
    }

    public void console()
    {
        //ProcessBuilder pb = new ProcessBuilder("clear");
        //Process process = Runtime.getRuntime().exec("clear");

        new CleanCommand().execute();

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
        while(!stringCommand.equals("exit"));
    }

    private void println(List<String> result)
    {
        for(String s : result)
            printer.println(s);
    }
}