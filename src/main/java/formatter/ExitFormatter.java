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
