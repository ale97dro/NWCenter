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
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

public class HistoryFormatterTest
{
    @Mock
    private List<String> history;

    private HistoryFormatter formatter;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);

        for(int i = 0; i < 3; i++)
            when(history.get(i)).thenReturn("command" + i);
        when(history.size()).thenReturn(3);

        formatter = new HistoryFormatter(history);
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

        assertEquals(2, result.size());
        assertEquals("command0", result.get(0));
        assertEquals("command1", result.get(1));
    }
}
