package command;

import formatter.Formatter;
import formatter.HistoryFormatter;

import java.util.List;

public class HistoryCommand implements Command
{
    private List<String> history;

    public HistoryCommand(List<String> history)
    {
        this.history = history;
    }

    @Override
    public Formatter execute()
    {
        return new HistoryFormatter(history);
    }
}
