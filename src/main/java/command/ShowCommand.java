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

/**
 * Perform filtering on logs databases and show the user the logs he's looking for.
 *
 * @author Alessandro Bianchi
 * @since v1.0
 */
public class ShowCommand implements Command
{
    private List<LogDB> dbs;
    private LogStatus logsStatus;
    private String startTime;
    private String endTime;
    private double maxTime;

    /**
     * Factory method for ShowCommand.
     * @param container {@link model.DBContainer} that contains all the logs databases.
     * @param dbs The databases selected by the user on which he wants to perform research.
     * @param logsStatus Select the logs with the specified type (SUCCEED, FAILED or ALL).
     * @param startTime Select the logs from this date.
     * @param endTime Select the logs until this date.
     * @param maxTime Select the logs with response time lower than this value.
     * @return a new ShowCommand instance.
     *
     * @since v1.0
     */
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

    /**
     * Private constructor for ShowCommand. The user must use the factory method {@link command.ShowCommand#getInstance(DBContainer, List, LogStatus, String, String, double)}.
     * @param logsStatus Select the logs with the specified type (SUCCEED, FAILED or ALL).
     * @param startTime Select the logs from this date.
     * @param endTime Select the logs until this date.
     * @param maxTime Select the logs with response time lower than this value.
     *
     * @since v1.0
     */
    private ShowCommand(LogStatus logsStatus, String startTime, String endTime, double maxTime)
    {
        this.logsStatus = logsStatus;
        this.startTime = startTime;
        this.endTime = endTime;
        this.maxTime = maxTime;
    }

    /**
     * Perform the research on the logs databases.
     * Apply filters based on log status, dates and time.
     * @return {@link formatter.ShowFormatter} to show the result of the research.
     *
     * @since v1.0
     */
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

    /**
     * Filter the logs by their type: SUCCEED, FAILED or ALL. Only logs with matching type will be kept.
     * @param logs All the logs from the previous filtering operation.
     * @return Logs filtered by status.
     *
     * @since v1.0
     */
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

    /**
     * Filter the logs by their time: logs with time greater than {@link command.ShowCommand#maxTime} will be kept.
     * @param logs All the logs from the previous filtering operation.
     * @return Logs filtered by time.
     *
     * @since v1.0
     */
    private List<Log> filterLogsByMaxTime(List<Log> logs)
    {
        List<Log> filteredLogs = new ArrayList<>();

        for(Log l : logs)
            if(l.getTime() >= maxTime)
                filteredLogs.add(l);

        return filteredLogs;
    }
}
