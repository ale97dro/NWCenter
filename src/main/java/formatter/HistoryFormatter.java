/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package formatter;

import console.ConsolePrinter;

import java.util.List;

public class HistoryFormatter implements Formatter
{
    private List<String> history;

    public HistoryFormatter(List<String> history)
    {
        this.history = history;
    }

    @Override
    public void printOnConsole(ConsolePrinter printer)
    {
        for(int i = 0; i < history.size() - 1; i++)
            printer.println(history.get(i));
    }
}
