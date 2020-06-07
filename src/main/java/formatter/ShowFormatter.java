/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package formatter;

import model.Log;
import model.LogStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ShowFormatter implements Formatter
{
    private List<Log> logs;

    public ShowFormatter(List<Log> logs)
    {
        this.logs = logs;
    }

    @Override
    public List<String> format()
    {
        List<String> result = new ArrayList<>();

        for(Log l : logs)
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

            result.add(log.toString());
        }

        return result;
    }

    private String add0(int value)
    {
        if(value < 10)
            return "0" + value;

        return String.valueOf(value);
    }
}
