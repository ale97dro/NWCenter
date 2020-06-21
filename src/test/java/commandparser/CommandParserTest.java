/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package commandparser;

import command.*;
import model.DBContainer;
import model.Environment;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CommandParserTest
{
    private CommandParser parser;
    @Mock
    private Environment env;
    @Mock
    private List<String> history;
    @Mock
    private DBContainer container;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);

        when(env.getHistory()).thenReturn(history);
        when(env.getContainer()).thenReturn(container);
        parser = new CommandParser(env);
    }

    @Test
    public void instanceTest()
    {
        assertNotNull(parser);
    }

    @Test
    public void clearParseTest()
    {
        Command command = parser.parse("clear");
        verify(env, times(1)).getHistory();
        assertEquals(ClearCommand.class, command.getClass());
    }

    @Test
    public void exitParseTest()
    {
        Command command = parser.parse("exit");
        verify(env, times(1)).getHistory();
        assertEquals(ExitCommand.class, command.getClass());
    }

    @Test
    public void historyParseTest()
    {
        Command command = parser.parse("history");
        verify(env, times(2)).getHistory();
        assertEquals(HistoryCommand.class, command.getClass());
    }

    @Test
    public void loadParseTest()
    {
        Command command = parser.parse("load path");
        verify(env, times(1)).getHistory();
        verify(env, times(1)).getContainer();
        assertEquals(LoadCommand.class, command.getClass());

        command = parser.parse("load");
        verify(env, times(2)).getHistory();
        verify(env, times(1)).getContainer();
        assertNull(command);
    }

    @Test
    public void resetParseTest()
    {
        Command command = parser.parse("reset");
        verify(env, times(1)).getHistory();
        assertEquals(ResetCommand.class, command.getClass());
    }

    @Test
    public void showParseTest()
    {
        Command command = parser.parse("show");
        verify(env, times(1)).getHistory();
        verify(env, times(1)).getContainer();
        assertEquals(ShowCommand.class, command.getClass());

        //Only options
        command = parser.parse("show -f");
        assertEquals(ShowCommand.class, command.getClass());
        command = parser.parse("show -s");
        assertEquals(ShowCommand.class, command.getClass());

        //Options with parameter
        command = parser.parse("show -db path");
        assertEquals(ShowCommand.class, command.getClass());
        command = parser.parse("show -st date");
        assertEquals(ShowCommand.class, command.getClass());
        command = parser.parse("show -et date");
        assertEquals(ShowCommand.class, command.getClass());
        command = parser.parse("show -t 10");
        assertEquals(ShowCommand.class, command.getClass());

        //Invalid option
        command = parser.parse("show f");
        assertNull(command);
    }

    @Test
    public void unloadParseTest()
    {
        Command command = parser.parse("unload db");
        verify(env, times(1)).getHistory();
        verify(env, times(1)).getContainer();
        assertEquals(UnloadCommand.class, command.getClass());

        command = parser.parse("unload");
        verify(env, times(2)).getHistory();
        verify(env, times(1)).getContainer();
        assertNull(command);
    }

    @Test
    public void notExistingCommandParseTest()
    {
        Command command = parser.parse("noExist");
        verify(env, times(1)).getHistory();
        assertNull(command);
    }
}
