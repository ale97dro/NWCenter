package model;

import java.time.LocalDateTime;

public class Log 
{
    private LocalDateTime date;
    private String weekDay;
    private double time;
    private String destination;
    private String destinationIp;

    public Log(LocalDateTime date, String weekDay, double time, String destination, String destinationIp)
    {
        this.date = date;
        this.weekDay = weekDay;
        this.time = time;
        this.destination = destination;
        this.destinationIp = destinationIp;
    }

    public LocalDateTime getDate() 
    {
        return date;
    }

    public String getWeekDay()
    {
        return weekDay;
    }

    public double getTime()
    {
        return time;
    }

    public String getDestination() 
    {
        return destination;
    }

    public String getDestinationIp()
    {
        return destinationIp;
    }
}