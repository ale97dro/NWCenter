package commandparser;

import command.*;
import console.ConsoleWriter;
import model.DBContainer;
import model.LogStatus;

import java.util.ArrayList;
import java.util.List;

public class CommandParser
{
    private ConsoleWriter writer;
    private DBContainer container;

    public CommandParser(ConsoleWriter writer, DBContainer container)
    {
        this.container = container;
        this.writer = writer;
    }

    public Command parse (String text)
    {
        String[] command = text.split(" ");

        for(int i = 0; i < command.length; i++)
            command[i] = command[i].toLowerCase();


        switch (command[0])
        {
            case "clear":
                return new CleanCommand(writer);
            case "exit":
                return null;
            case "load":
                return new LoadCommand(command[1], container);
            case "show":
                return parseShow(command);
            case "unload":
                return new UnloadCommand(command[1], container);
        }

        return null;
    }

    private Command parseShow(String[] command)
    {
        /*
            0: show
         */

        LogStatus logsStatus = LogStatus.ALL;
        List<String> logsDb = new ArrayList<>();
        String startTime = "";
        String endTime = "";


        for(int i = 1; i < command.length; i++)
        {
            switch (command[i])
            {
                case "-f":
                    logsStatus = LogStatus.FAILED;
                    break;
                case "-s":
                    logsStatus = LogStatus.SUCCEED;
                    break;
                case "-db":
                    logsDb.add(command[++i]);
                    break;
                case "-st":
                    startTime = command[++i];
                    break;
                case "-et":
                    endTime = command[++i];
                    break;
                default:
                    return null;
            }
        }

        return ShowCommand.getInstance(container, writer, logsDb, logsStatus, startTime, endTime);
    }
}
