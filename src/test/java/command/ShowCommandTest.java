/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.Formatter;
import formatter.ShowFormatter;
import model.DBContainer;
import model.LogDB;
import model.LogStatus;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class ShowCommandTest
{
    private Command command;
    @Mock
    private DBContainer container;
    @Mock
    private LogDB db1;
    @Mock
    private LogDB db2;
    @Mock
    private List<String> dbs;
    @Mock
    private Iterator<String> dbsIterator;
    private LogStatus status;
    private String startTime;
    private String endTime;
    private double maxTime;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        command = ShowCommand.getInstance(container, dbs, status, startTime, endTime, maxTime);
    }

    @Test
    public void instanceTest()
    {
        assertNotNull(command);
    }

    @Test
    public void executeTest()
    {
        Formatter formatter = command.execute();
        assertEquals(ShowFormatter.class, formatter.getClass());
    }

    @Ignore
    @Test
    public void executeTest02()
    {
        //Setup dbs list
        when(dbs.size()).thenReturn(1);
        when(dbsIterator.hasNext()).thenReturn(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
        when(dbsIterator.next()).thenReturn("db1", "db2");
        when(dbs.iterator()).thenReturn(dbsIterator);

        //Setup container
        when(container.getDb("db1")).thenReturn(db1);
        when(container.getDb("db2")).thenReturn(db2);

//        when(db1.getLogs()).thenReturn(logs1);
//        when(db2.getLogs()).thenReturn(logs2);

        //Setup dbs

        command = ShowCommand.getInstance(container, dbs, status, startTime, endTime, maxTime);

        Formatter formatter = command.execute();
        assertEquals(ShowFormatter.class, formatter.getClass());
    }
}
