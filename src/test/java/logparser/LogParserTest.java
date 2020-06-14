/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package logparser;

import model.Log;
import model.LogDB;
import model.LogStatus;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LogParserTest
{
    private LogParser parser;

    @Before
    public void setup()
    {
        parser = new LogParser();
    }

    @Test
    public void instanceTest()
    {
        assertNotNull(parser);
    }

    @Test
    public void parseTest()
    {
        int expectedLogs = 3;
        String expectedDBName = "test_log";

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test_log").getFile());
        assertNotNull(file);

        LogDB db = LogParser.parse(file.getPath());

        assertEquals(expectedLogs, db.getLogs().size());
        assertEquals(expectedDBName, db.getName());

        checkParsedLog(db.getLogs().get(0), LocalDateTime.of(2020, 5, 26, 5, 32, 30), "Tue", 0, "google.com", "192.168.0.1", LogStatus.FAILED);
        checkParsedLog(db.getLogs().get(1), LocalDateTime.of(2020, 5, 26, 5, 34, 5), "Tue", 0, null, null, LogStatus.FAILED);
        checkParsedLog(db.getLogs().get(2), LocalDateTime.of(2020, 5, 26, 5, 35, 45), "Tue", 13.8, "google.com", "192.168.0.1", LogStatus.SUCCEED);

    }

    public void checkParsedLog(Log log, LocalDateTime date, String weekDay, double time, String destination, String destinationIp, LogStatus status)
    {
        assertEquals(date, log.getDate());
        assertEquals(weekDay, log.getWeekDay());
        assertEquals(time, log.getTime(), 0.001);
        assertEquals(destination, log.getDestination());
        assertEquals(destinationIp, log.getDestinationIp());
        assertEquals(status, log.getStatus());
    }
}
