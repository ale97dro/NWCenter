/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package formatter;

import model.Log;
import model.LogStatus;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShowFormatterTest
{
    @Mock
    private List<Log> logs;
    @Mock
    private Iterator<Log> iterator;

    private ShowFormatter formatter;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);

        //Mock first log
        Log log1 = mock(Log.class);
        when(log1.getDestination()).thenReturn("google.com");
        when(log1.getStatus()).thenReturn(LogStatus.FAILED);
        when(log1.getTime()).thenReturn(12.5);
        when(log1.getDate()).thenReturn(LocalDateTime.of(2020, 6, 7, 11, 17, 10));

        //Mock second log
        Log log2 = mock(Log.class);
        when(log2.getDestination()).thenReturn("google.com");
        when(log2.getStatus()).thenReturn(LogStatus.SUCCEED);
        when(log2.getTime()).thenReturn(12.5);
        when(log2.getDate()).thenReturn(LocalDateTime.of(2020, 10, 7, 11, 17, 10));

        //Mock iterator
        when(iterator.hasNext()).thenReturn(Boolean.TRUE, Boolean.TRUE, Boolean.FALSE);
        when(iterator.next()).thenReturn(log1, log2);
        when(logs.iterator()).thenReturn(iterator);

        formatter = new ShowFormatter(logs);
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
        assertEquals("11:17:10 07-06-2020 google.com FAILED\n", result.get(0));
        assertEquals("11:17:10 07-10-2020 google.com 12.5\n", result.get(1));
    }
}
