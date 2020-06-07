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
import static org.mockito.Mockito.when;

public class DBContainerTest
{
    private DBContainer container;
    @Mock
    private LogDB db1;
    @Mock
    private LogDB db2;
    @Mock
    private LogDB db3;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        container = new DBContainer();

        when(db1.getName()).thenReturn("db1");
        when(db2.getName()).thenReturn("db2");
        when(db3.getName()).thenReturn("db3");

    }

    @Test
    public void instanceTest()
    {
        assertNotNull(container);
    }

    @Test
    public void addDbTest()
    {
        container.addDb(db1);
        container.addDb(db2);
        container.addDb(db3);
        assertEquals(3, container.size());
    }

    @Test
    public void removeDbTest()
    {
        container.addDb(db1);
        container.addDb(db2);
        container.addDb(db3);

        //Remove an existing db
        LogDB removedDb = container.removeDb("db1");
        assertSame(db1, removedDb);
        assertEquals(2, container.size());

        //Remove a non-existing db
        removedDb = container.removeDb("db1");
        assertNull(removedDb);
        assertEquals(2, container.size());
    }

    @Test
    public void getDbTest()
    {
        container.addDb(db1);
        container.addDb(db2);
        container.addDb(db3);

        //Search for an existing db
        LogDB searchedDb = container.getDb("db1");
        assertSame(db1, searchedDb);
        assertEquals(3, container.size());

        //Search for a non-existing db
        searchedDb = container.getDb("db4");
        assertNull(searchedDb);
        assertEquals(3, container.size());
    }

    @Test
    public void getAllDbsTest()
    {
        container.addDb(db1);
        container.addDb(db2);
        container.addDb(db3);

        List<LogDB> dbs = container.getAllDbs();
        assertEquals(container.size(), dbs.size());
        assertSame(db1, dbs.get(0));
        assertSame(db2, dbs.get(1));
        assertSame(db3, dbs.get(2));
    }

    @Test
    public void clearTest()
    {
        container.addDb(db1);
        container.addDb(db2);

        container.clear();
        assertEquals(0, container.size());
    }

    @Test
    public void sizeTest()
    {
        container.addDb(db1);
        container.addDb(db2);

        assertEquals(2, container.size());
    }

}
