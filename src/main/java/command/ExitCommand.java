package command;

import console.ConsoleWriter;

public class ExitCommand implements Command
{
    private ConsoleWriter writer;

    public ExitCommand(ConsoleWriter writer)
    {
        this.writer = writer;
    }

    @Override
    public void execute()
    {
        writer.println("Closing NW Center...");
    }
}
