/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package formatter;

import console.ConsolePrinter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class HistoryFormatterTest
{
    @Mock
    private List<String> history;
    @Mock
    private ConsolePrinter printer;

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
        formatter.printOnConsole(printer);

        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(printer, times(2)).println(argument.capture());
    }
}
