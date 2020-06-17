/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.Formatter;
import formatter.ShowFormatter;
import model.DBContainer;
import model.Log;
import model.LogDB;
import model.LogStatus;

import java.util.ArrayList;
import java.util.List;

public class ShowCommand implements Command
{
    private List<LogDB> dbs;
    private LogStatus logsStatus;
    private String startTime;
    private String endTime;
    private double maxTime;

    public static ShowCommand getInstance(DBContainer container, List<String> dbs, LogStatus logsStatus, String startTime, String endTime, double maxTime)
    {
        ShowCommand command = new ShowCommand(logsStatus, startTime, endTime, maxTime);

        if(dbs.size() == 0)
            command.dbs = container.getAllDbs();
        else
        {
            command.dbs = new ArrayList<>();
            for (String d : dbs)
            {
                if (container.getDb(d) != null)
                    command.dbs.add(container.getDb(d));
            }
        }

        return command;
    }

    private ShowCommand(LogStatus logsStatus, String startTime, String endTime, double maxTime)
    {
        this.logsStatus = logsStatus;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxTime = maxTime;
    }


    @Override
    public Formatter execute()
    {
        List<Log> tempFiltered;
        List<Log> filteredLogs = new ArrayList<>();

        //for each db, extract logs and filter them
        for(LogDB db : dbs)
        {
            //tempFiltered.addAll(filterLogsByType(db.getLogs()));
            tempFiltered = filterLogsByType(db.getLogs());
            tempFiltered = filterLogsByMaxTime(tempFiltered);
            //todo: implements filtering for dates


            //once all the filtering are done, save the result
            filteredLogs.addAll(tempFiltered);
        }

        return new ShowFormatter(filteredLogs);
    }

    private List<Log> filterLogsByType(List<Log> logs)
    {
        List<Log> filteredLogs = new ArrayList<>();

        if(!logsStatus.equals(LogStatus.ALL))
        {
            for(Log l : logs)
                if(l.getStatus().equals(logsStatus))
                    filteredLogs.add(l);
        }
        else
            filteredLogs.addAll(logs);

        return filteredLogs;
    }

    private List<Log> filterLogsByMaxTime(List<Log> logs)
    {
        List<Log> filteredLogs = new ArrayList<>();

        for(Log l : logs)
            if(l.getTime() >= maxTime)
                filteredLogs.add(l);

        return filteredLogs;
    }
}
