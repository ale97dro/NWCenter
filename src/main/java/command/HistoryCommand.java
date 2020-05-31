package command;

import console.ConsoleWriter;

import java.util.List;

public class HistoryCommand implements Command
{
    private ConsoleWriter writer;
    private List<String> history;

    public HistoryCommand(ConsoleWriter writer, List<String> history)
    {
        this.writer = writer;
        this.history = history;
    }

    @Override
    public void execute()
    {
        for(int i = 0; i < history.size() - 1; i++)
            writer.println(history.get(i));
    }
}
