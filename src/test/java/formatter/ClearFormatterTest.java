/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package formatter;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClearFormatterTest
{
    private ClearFormatter formatter;
    private String expectedClearOutput;

    @Before
    public void setup()
    {
        expectedClearOutput = "clearOutput";
        formatter = new ClearFormatter(expectedClearOutput);
    }

    @Test
    public void instanceTest()
    {
        assertNotNull(formatter);
    }

    @Test
    public void printOnConsoleTest()
    {
        List<String> result = formatter.format();

        assertEquals(1, result.size());
        assertEquals(expectedClearOutput, result.get(0));
    }
}
