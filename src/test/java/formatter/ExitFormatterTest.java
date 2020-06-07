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

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ExitFormatterTest
{
    @Mock
    private ConsolePrinter printer;

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
        formatter.printOnConsole(printer);

        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        verify(printer, times(1)).println(argument.capture());
    }
}
