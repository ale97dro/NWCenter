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
import model.Environment;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class ResetCommandTest
{
    private Command command;

    @Mock
    private DBContainer container;
    @Mock
    private List<String> history;
    @Mock
    private Environment environment;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);

        when(environment.getContainer()).thenReturn(container);
        when(environment.getHistory()).thenReturn(history);

        command = new ResetCommand(environment);
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
        verify(environment.getContainer(), times(1)).clear();
        verify(environment.getHistory(), times(1)).clear();

        assertNull(formatter);
    }
}
