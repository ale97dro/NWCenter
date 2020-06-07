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
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ExitFormatterTest
{
    private ExitFormatter formatter;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);

        formatter = new ExitFormatter();
    }

    @Test
    public void instanceTest()
    {
        assertNotNull(formatter);
    }

    @Test
    public void printOnConsoleTest()
    {
        String expectedOutput = "Closing NW Center...";
        List<String> result = formatter.format();

        assertEquals(1, result.size());
        assertEquals(expectedOutput, result.get(0));

    }
}
