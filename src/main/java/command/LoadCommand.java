package command;

import logparser.LogParser;
import model.DBContainer;
import model.LogDB;

public class LoadCommand implements Command
{
    private String path;
    private DBContainer container;

    public LoadCommand(String path, DBContainer container)
    {
        this.path = path;
        this.container = container;
    }

    @Override
    public void execute()
    {
        LogDB db = LogParser.parse(path);
        container.addDb(db);
    }
}
