package command;

import formatter.Formatter;
import model.DBContainer;

public class UnloadCommand implements Command
{
    private DBContainer container;
    private String dbName;

    public UnloadCommand(String dbName, DBContainer container)
    {
        this.container = container;
        this.dbName = dbName;
    }

    @Override
    public Formatter execute()
    {
        container.removeDb(dbName);

        return null;
    }
}
