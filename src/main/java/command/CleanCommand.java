package command;

import console.ConsoleWriter;

public class CleanCommand implements Command
{
    private ConsoleWriter writer;

    public CleanCommand(ConsoleWriter writer)
    {
        this.writer = writer;
    }

    @Override
    public void execute()
    {
        //out.print("\033[H\033[2J");
        //out.flush();

        writer.print("\033[H\033[2J");
       writer.flush();
    }
}
