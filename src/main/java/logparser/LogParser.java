package logparser;

import exception.DateParseException;
import model.Log;
import model.LogDB;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class LogParser
{
    private static final int SUCCEED_PARTS = 36;
    private static final int FAILED_PARTS = 22;

    private List<Log> test = new ArrayList<>();


    public static LogDB parse(String path)
    {
        List<Log> logs = new ArrayList<>();

        try(BufferedReader in = new BufferedReader(new FileReader(path)))
        {
            try
            {
                String date = "";
                while((date = in.readLine()) != null)
                {
                    //date = in.readLine();
                    isDate(date);
                    String command = in.readLine();

                    if (isPing(command))
                    {
                        String[] commandParts = command.split(" ");

                        if (commandParts.length == SUCCEED_PARTS)
                            logs.add(succeedPing(commandParts, date));
                        else
                            if (commandParts.length == FAILED_PARTS)
                                logs.add(failedPing(commandParts, date));
                    }

                }
            }
            catch(DateParseException e)
            {
                System.out.println("ciao");
            }


        }
        catch(IOException e)
        {
            System.out.println("ciao");
        }

        return new LogDB(path, logs);
    }

    private static Log succeedPing(String[] command, String date)
    {
        String destination = command[1];
        String destinationIp = command[2].substring(1, command[2].length() - 1);
        double time = Double.parseDouble(command[14].substring(5));

        return new Log(parseDate(date), date.split(" ")[0], time, destination, destinationIp);
    }

    private static Log failedPing(String[] command, String date)
    {
        String destination = command[1];
        String destinationIp = command[2].substring(1, command[2].length() - 1);

        return new Log(parseDate(date), date.split(" ")[0], 0, destination, destinationIp);
    }

    private static void isDate(String date) throws DateParseException
    {
        String day = date.split(" ")[0].toUpperCase();

        switch(day)
        {
            case "MON":
            case "TUE":
            case "WED":
            case "THU":
            case "FRI":
            case "SAT":
            case "SUN":
                return;
        }

        throw new DateParseException("Find " + day + ": invalid day");
    }

    private static LocalDateTime parseDate(String date)
    {
        String[] dateParts = date.split(" ");

        //String weekDay = dateParts[0];
        String month =  dateParts[1];
        int day = Integer.parseInt(dateParts[2]);
        String time = dateParts[3];
        int year = Integer.parseInt(dateParts[5]);

        String[] timeParts = time.split(":");
        int hour = Integer.parseInt(timeParts[0]);
        int minutes = Integer.parseInt(timeParts[1]);
        int seconds = Integer.parseInt(timeParts[2]);

        return LocalDateTime.of(year, Month.valueOf(month.toUpperCase()), day, hour, minutes, seconds);
    }

    private static boolean isPing(String command)
    {
        String ping = command.split(" ")[0];

        return ping.equals("PING");
    }
}