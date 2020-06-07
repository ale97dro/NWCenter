/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package exception;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class CommandParseExceptionTest
{
    private CommandParseException ex;
    private String expectedMessage;

    @Before
    public void setup()
    {
        expectedMessage = "Command error";
        ex = new CommandParseException(expectedMessage);
    }

    @Test
    public void instanceTest()
    {
        assertNotNull(ex);
    }

    @Test
    public void getMessageTest()
    {
        Assert.assertEquals(expectedMessage, ex.getMessage());
    }
}
