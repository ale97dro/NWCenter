/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package console;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintStream;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ConsolePrinterTest
{
    @Mock
    private PrintStream stream;
    private String expectedOutput;

    private ConsolePrinter printer;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        expectedOutput = "OUTPUT";

        printer = new ConsolePrinter(stream);
    }

    @Test
    public void instanceTest()
    {
        assertNotNull(printer);
    }

    @Test
    public void printTest()
    {
        printer.print(expectedOutput);
        verify(stream, times(1)).print(expectedOutput);
    }

    @Test
    public void printlnTest()
    {
        printer.println(expectedOutput);
        verify(stream, times(1)).println(expectedOutput);
    }

    @Test
    public void flushTest()
    {
        printer.flush();
        verify(stream, times(1)).flush();
    }
}
