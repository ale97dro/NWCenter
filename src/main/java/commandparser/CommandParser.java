package commandparser;

import app.Console;
import command.CleanCommand;
import command.Command;
import command.LoadCommand;
import console.ConsoleWriter;

public class CommandParser
{
    private ConsoleWriter writer;

    public CommandParser(ConsoleWriter writer)
    {
        this.writer = writer;
    }

    public Command parse(String text)
    {
        String[] command = text.split(" ");

        for(int i = 0; i < command.length; i++)
            command[i] = command[i].toLowerCase();


        switch (command[0])
        {
            case "clear":
                return new CleanCommand(writer);
            case "load":
                return new LoadCommand(command[1]);
            case "exit":
                return null;
        }

        return null;
    }
}
