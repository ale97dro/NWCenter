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
import model.LogDB;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class LoadCommandTest
{
    private Command command;
    private String path;
    @Mock
    private DBContainer container;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test_log").getFile());
        assertNotNull(file);
        path = file.getPath();

        command = new LoadCommand(path, container);
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
        ArgumentCaptor<LogDB> argument = ArgumentCaptor.forClass(LogDB.class);
        verify(container, times(1)).addDb(argument.capture());
    }
}
