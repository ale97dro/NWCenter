package commandparser;

import command.*;
import model.Environment;
import model.LogStatus;

import java.util.ArrayList;
import java.util.List;

public class CommandParser
{
    private Environment environment;

    public CommandParser(Environment environment)
    {
        this.environment = environment;
    }

    public Command parse (String stringCommand)
    {
        String[] command = stringCommand.split(" ");

        for(int i = 0; i < command.length; i++)
            command[i] = command[i].toLowerCase();

        environment.getHistory().add(stringCommand);

        try
        {
            switch (command[0])
            {
                case "clear":
                    return new CleanCommand(environment.getWriter());
                case "exit":
                    return new ExitCommand(environment.getWriter());
                case "history":
                    return new HistoryCommand(environment.getWriter(), environment.getHistory());
                case "load":
                    return new LoadCommand(command[1], environment.getContainer());
                case "show":
                    return parseShow(command);
                case "unload":
                    return new UnloadCommand(command[1], environment.getContainer());
            }
        }
        catch (Exception ex)
        {

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

        return ShowCommand.getInstance(environment.getContainer(), environment.getWriter(), logsDb, logsStatus, startTime, endTime);
    }
}
