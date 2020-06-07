/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LogTest
{
    private LocalDateTime expectedDate;
    private String expectedWeekDay;
    private double expectedTime;
    private String expectedDestination;
    private String expectedDestinationIp;
    private LogStatus expectedLogStatus;

    private Log log;

    @Before
    public void setup()
    {
        expectedDate = LocalDateTime.of(2020, 6, 7, 11, 17, 10);
        expectedWeekDay = "Sun";
        expectedTime = 12.5;
        expectedDestination = "home";
        expectedDestinationIp = "127.0.0.1";
        expectedLogStatus = LogStatus.ALL;

        this.log = new Log(expectedDate, expectedWeekDay, expectedTime, expectedDestination, expectedDestinationIp, expectedLogStatus);
    }

    @Test
    public void instanceLog()
    {
        assertNotNull(log);
    }

    @Test
    public void getDateTest()
    {
        assertEquals(expectedDate, log.getDate());
    }

    @Test
    public void getWeekDay()
    {
        assertEquals(expectedWeekDay, log.getWeekDay());
    }

    @Test
    public void getTimeTest()
    {
        assertEquals(expectedTime, log.getTime(), 0.1);
    }

    @Test
    public void getDestinationTest()
    {
        assertEquals(expectedDestination, log.getDestination());
    }

    @Test
    public void getDestinationIpTest()
    {
        assertEquals(expectedDestinationIp, log.getDestinationIp());
    }

    @Test
    public void getLogStatusTest()
    {
        assertEquals(expectedLogStatus, log.getStatus());
    }



}
