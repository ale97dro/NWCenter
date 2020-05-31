package command;

import console.ConsolePrinter;
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

    public static ShowCommand getInstance(DBContainer container, List<String> dbs, LogStatus logsStatus, String startTime, String endTime)
    {
        ShowCommand command = new ShowCommand(logsStatus, startTime, endTime);

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

    private ShowCommand(LogStatus logsStatus, String startTime, String endTime)
    {
        this.logsStatus = logsStatus;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    @Override
    public Formatter execute()
    {
        List<Log> filteredLogs = new ArrayList<>();

        //for each db, extract logs
        for(LogDB db : dbs)
            filteredLogs.addAll(filterLogsByType(db.getLogs()));

        //todo: implements filtering for dates


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
}
