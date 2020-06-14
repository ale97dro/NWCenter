/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.Formatter;
import model.DBContainer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UnloadCommandTest
{
    private Command command;
    private String dbName;
    @Mock
    private DBContainer container;


    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        dbName = "dbTest";

        command = new UnloadCommand(dbName, container);
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
        verify(container, times(1)).removeDb(dbName);
        assertNull(formatter);
    }
}
