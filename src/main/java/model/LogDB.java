/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package model;

import java.util.List;

public class LogDB
{
    private String name;
    private List<Log> logs;
    private LogsType logsType;

    public LogDB(String name, List<Log> logs, LogsType logsType)
    {
        this.name = name;
        this.logs = logs;
        this.logsType = logsType;
    }

    public List<Log> getLogs()
    {
        return logs;
    }

    public String getName()
    {
        return name;
    }

    public LogsType getLogsType()
    {
        return logsType;
    }
}