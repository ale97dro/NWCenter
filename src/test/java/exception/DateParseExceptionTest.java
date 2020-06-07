/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package exception;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class DateParseExceptionTest
{
    private DateParseException ex;
    private String expectedMessage;

    @Before
    public void setup()
    {
        expectedMessage = "Date error";
        ex = new DateParseException(expectedMessage);
    }

    @Test
    public void instanceTest()
    {
        assertNotNull(ex);
    }

    @Test
    public void getMessageTest()
    {
        assertEquals(expectedMessage, ex.getMessage());
    }
}
