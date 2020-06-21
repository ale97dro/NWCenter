/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.ExitFormatter;
import formatter.Formatter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExitCommandTest
{
    private Command command;

    @Before
    public void setup()
    {
        this.command = new ExitCommand();
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
        assertEquals(ExitFormatter.class, formatter.getClass());
    }
}
