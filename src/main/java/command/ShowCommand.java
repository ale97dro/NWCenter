package command;

import console.ConsoleWriter;
import model.DBContainer;
import model.Log;
import model.LogDB;
import model.LogStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowCommand implements Command
{
    private ConsoleWriter writer;
    private List<LogDB> dbs;
    private LogStatus logsStatus;
    private String startTime;
    private String endTime;

    public static ShowCommand getInstance(DBContainer container, ConsoleWriter writer, List<String> dbs, LogStatus logsStatus, String startTime, String endTime)
    {
        ShowCommand command = new ShowCommand(writer, logsStatus, startTime, endTime);

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

    private ShowCommand(ConsoleWriter writer, LogStatus logsStatus, String startTime, String endTime)
    {
        this.writer = writer;
        this.logsStatus = logsStatus;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    @Override
    public void execute()
    {
        List<Log> filteredLogs = new ArrayList<>();

        //for each db, extract logs
        for(LogDB db : dbs)
            filteredLogs.addAll(filterLogsByType(db.getLogs()));


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
