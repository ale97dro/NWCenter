package command;

import formatter.ExitFormatter;
import formatter.Formatter;

public class ExitCommand implements Command
{
    @Override
    public Formatter execute()
    {
        return new ExitFormatter();
    }
}
