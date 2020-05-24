package model;

import java.time.LocalDateTime;

public class Log 
{
    private LocalDateTime date;
    private int time;
    private String destination;
    private String destinationIp;

    public Log(LocalDateTime date, int time, String destination, String destinationIp)
    {
        this.date = date;
        this.time = time;
        this.destination = destination;
        this.destinationIp = destinationIp;
    }

    public LocalDateTime getDate() 
    {
        return date;
    }

    public int getTime() 
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