package command;

import console.ConsoleWriter;
import model.DBContainer;
import model.Log;
import model.LogDB;
import model.LogStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowCommand extends Command
{
    private DBContainer container;
    private ConsoleWriter writer;
    private List<String> dbs;
    private LogStatus logsStatus;
    private String startTime;
    private String endTime;

    public ShowCommand(DBContainer container, ConsoleWriter writer, List<String> dbs, LogStatus logsStatus, String startTime, String endTime)
    {
        this.container = container;
        this.writer = writer;
        this.dbs = dbs;
        this.logsStatus = logsStatus;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    @Override
    public void execute()
    {
        LogDB db = container.getDb(dbs.get(0));

        if(db == null)
            return;

        List<Log> filteredLogs;

        filteredLogs = filterLogsByType(db.getLogs());


        for(Log l : filteredLogs)
        {
            StringBuilder log = new StringBuilder();

            LocalDateTime date = l.getDate();

            //Hour
            log.append(add0(date.getHour()));
            log.append(":");
            log.append(add0(date.getMinute()));
            log.append(":");
            log.append(add0(date.getSecond()));
            log.append(" ");
            //Day
            log.append(add0(date.getDayOfMonth()));
            log.append("-");
            log.append(add0(date.getMonthValue()));
            log.append("-");
            log.append(date.getYear());


            log.append(" ");
            log.append(l.getDestination());
            log.append(" ");

            if(l.getStatus().equals(LogStatus.FAILED))
                log.append(l.getStatus());
            else
                log.append(l.getTime());

            writer.println(log.toString());
        }
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

    private String add0(int value)
    {
        if(value < 10)
            return "0" + value;

        return String.valueOf(value);
    }
}
