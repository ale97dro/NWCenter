package console;

import java.io.PrintStream;

public class ConsoleWriter
{
    private PrintStream out;

    public ConsoleWriter(PrintStream out)
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
