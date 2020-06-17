/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

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
                    return new CleanCommand();
                case "exit":
                    return new ExitCommand();
                case "history":
                    return new HistoryCommand(environment.getHistory());
                case "load":
                    return new LoadCommand(command[1], environment.getContainer());
                case "reset":
                    return new ResetCommand(environment);
                case "show":
                    return parseShow(command);
                case "unload":
                    return new UnloadCommand(command[1], environment.getContainer());
                default:
                    return null;
            }
        }
        catch (Exception ex)
        {

        }

        return null;
    }

    private ShowCommand parseShow(String[] command)
    {
        /*
            0: show
         */

        LogStatus logsStatus = LogStatus.ALL;
        List<String> logsDb = new ArrayList<>();
        String startTime = "";
        String endTime = "";
        double maxTime = 0;


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
                case "-t":
                    maxTime = Double.parseDouble(command[++i]);
                    break;
                default:
                    return null;
            }
        }

        return ShowCommand.getInstance(environment.getContainer(), logsDb, logsStatus, startTime, endTime, maxTime);
    }
}
