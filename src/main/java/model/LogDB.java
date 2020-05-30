package model;

import java.util.List;

public class LogDB
{
    private String name;
    private List<Log> logs;

    public LogDB(String name, List<Log> logs)
    {
        this.name = name;
        this.logs = logs;
    }

    public List<Log> getLogs()
    {
        return logs;
    }

    public String getName()
    {
        return name;
    }
}