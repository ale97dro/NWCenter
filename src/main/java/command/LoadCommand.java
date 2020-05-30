package command;

import logparser.LogParser;
import model.LogDB;

public class LoadCommand implements Command<LogDB>
{
    private String path;

    public LoadCommand(String path)
    {
        this.path = path;
    }

    @Override
    public LogDB execute()
    {
        LogDB db = LogParser.parse(path);

        System.out.println("ciao");

        return db;
    }
}
