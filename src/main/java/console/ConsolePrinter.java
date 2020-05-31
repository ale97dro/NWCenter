package console;

import java.io.PrintStream;

public class ConsolePrinter
{
    private PrintStream out;

    public ConsolePrinter(PrintStream out)
    {
        this.out = out;
    }

    public void print(String text)
    {
        out.print(text);
    }

    public void println(String text)
    {
        out.println(text);
    }

    public void flush()
    {
        out.flush();
    }
}
