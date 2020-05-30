package command;

import console.ConsoleWriter;
import model.DBContainer;
import model.Log;
import model.LogDB;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowCommand extends Command
{
    private static final String FAILED_TAG = "FAILED";
    private static final String SUCCEED_TAG = "SUCCEED";

    private DBContainer container;
    private ConsoleWriter writer;
    private List<String> dbs;
    private String logsType;
    private String startTime;
    private String endTime;

    public ShowCommand(DBContainer container, ConsoleWriter writer, List<String> dbs, String logsType, String startTime, String endTime)
    {
        this.container = container;
        this.writer = writer;
        this.dbs = dbs;
        this.logsType = logsType;
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

        if(logsType.equals(FAILED_TAG))
            filteredLogs = filterLogsByType(db.getLogs(), FAILED_TAG);
        else
            filteredLogs = filterLogsByType(db.getLogs(), SUCCEED_TAG);




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

            if(l.getType().equals(FAILED_TAG))
                log.append(l.getType());
            else
                log.append(l.getTime());

            writer.println(log.toString());
        }
    }

    private List<Log> filterLogsByType(List<Log> logs, String type)
    {
        List<Log> filteredLogs = new ArrayList<>();

        for(Log l : logs)
            if(l.getType().equals(type))
                filteredLogs.add(l);

        return filteredLogs;
    }

    private String add0(int value)
    {
        if(value < 10)
            return "0" + value;

        return String.valueOf(value);
    }
}
