/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.Formatter;
import formatter.HistoryFormatter;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HistoryCommandTest
{
    private Command command;
    private List<String> history = null;

    @Before
    public void setup()
    {
        command = new HistoryCommand(history);
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

        assertEquals(HistoryFormatter.class, formatter.getClass());
    }
}
