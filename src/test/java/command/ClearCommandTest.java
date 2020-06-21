/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.ClearFormatter;
import formatter.Formatter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClearCommandTest
{
    private Command windowsCommand;
    private Command ubuntuCommand;
    private String windows10;
    private String ubuntu;


    @Before
    public void setup()
    {
        windows10 = "Windows 10";
        ubuntu = "Ubuntu";

        windowsCommand = new ClearCommand("Windows 10");
        ubuntuCommand = new ClearCommand("Ubuntu");
    }

    @Test
    public void instanceTest()
    {
        assertNotNull(windowsCommand);
        assertNotNull(ubuntuCommand);
    }

    @Test
    public void executeWindowsClearTest()
    {
        Formatter formatter = windowsCommand.execute();
        assertNull(formatter);
    }

    @Test
    public void executeLinuxClearTest()
    {
        Formatter formatter = ubuntuCommand.execute();
        assertNotNull(formatter);
        assertEquals(ClearFormatter.class, formatter.getClass());
    }
}
