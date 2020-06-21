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
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;

public class LogDBTest
{
    @Mock
    private List<Log> expectedLogs;
    private String expectedName;
    private LogsType expectedLogsType;

    private LogDB db;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        expectedName = "TEST_DB";
        expectedLogsType = LogsType.BASH;

        db = new LogDB(expectedName, expectedLogs, expectedLogsType);
    }

    @Test
    public void instanceDB()
    {
        assertNotNull(db);
    }

    @Test
    public void getLogsTest()
    {
        assertEquals(expectedName, db.getName());
    }

    @Test
    public void getNameTest()
    {
        assertSame(expectedLogs, db.getLogs());
    }

    @Test
    public void getLogsTypeTest()
    {
        assertEquals(expectedLogsType, db.getLogsType());
    }
}
