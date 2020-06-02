/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package formatter;

import console.ConsolePrinter;

public class ExitFormatter implements Formatter
{
    @Override
    public void printOnConsole(ConsolePrinter printer)
    {
        printer.println("Closing NW Center...");
    }
}
