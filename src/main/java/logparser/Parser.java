package logparser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exception.CommandParseException;
import exception.DateParseException;
import model.Log;
import model.LogDB;

public class Parser 
{
    List<Log> test = new ArrayList<>();
    
    public static LogDB parse(String path)
    {
        try(BufferedReader in = new BufferedReader(new FileReader(path)))
        {
            try
            {
                String date = in.readLine();
                isDate(date);
                String command = in.readLine();
                isPing(command);
            }
            catch(DateParseException e)
            {

            }
            catch(CommandParseException e)
            {
                
            }
            

        }
        catch(IOException e)
        {

        }

        return null;
    }

    private static void isDate(String date) throws DateParseException
    {
        String day = date.split(" ")[0];

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

    private static void isPing(String command) throws CommandParseException
    {
        String ping = command.split(" ")[0];
        
        if(ping.equals("PING"))
            return;
        
        throw new CommandParseException("Find " + ping + ": expected PING");

    }
}