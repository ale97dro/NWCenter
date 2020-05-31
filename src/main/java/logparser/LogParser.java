package logparser;

import exception.DateParseException;
import model.Log;
import model.LogDB;
import model.LogStatus;

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

    public static LogDB parse(String path)
    {
        List<Log> logs = new ArrayList<>();

        path = path.replace("\\", "/");

        try(BufferedReader in = new BufferedReader(new FileReader(path)))
        {
            try
            {
                String date = "";
                while((date = in.readLine()) != null)
                {
                    isDate(date);
                    String command = in.readLine();

                    //if (isPing(command))
                    //{
                        String[] commandParts = command.split(" ");

                        if (commandParts.length == SUCCEED_PARTS)
                            logs.add(succeedPing(commandParts, date));
                        else
                            //if (commandParts.length == FAILED_PARTS)
                                logs.add(failedPing(commandParts, date));
                    //}

                }
            }
            catch(DateParseException e)
            {
            }
        }
        catch(IOException e)
        {
        }

        return new LogDB(dbNameParse(path), logs);
    }

    private static Log succeedPing(String[] command, String date)
    {
        String destination = command[1];
        String destinationIp = command[2].substring(1, command[2].length() - 1);
        double time = Double.parseDouble(command[14].substring(5));

        return new Log(parseDate(date), parseWeekDay(date), time, destination, destinationIp, LogStatus.SUCCEED);
    }

    private static Log failedPing(String[] command, String date)
    {
        if(command.length >= 3)
        {
            String destination = command[1];
            String destinationIp = command[2].substring(1, command[2].length() - 1);

            return new Log(parseDate(date), parseWeekDay(date), 0, destination, destinationIp, LogStatus.FAILED);
        }

        return new Log(parseDate(date), parseWeekDay(date), 0, null, null, LogStatus.FAILED);
    }

    private static void isDate(String date) throws DateParseException
    {
        String day = parseWeekDay(date).toUpperCase();

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

    private static String dbNameParse(String fullPath)
    {
        String[] pathParts = fullPath.split("/");

        return pathParts[pathParts.length - 1];
    }

    private static String parseWeekDay(String date)
    {
        return date.split(" ")[0];
    }

    private static boolean isPing(String command)
    {
        String ping = command.split(" ")[0];

        return ping.equals("PING");
    }
}