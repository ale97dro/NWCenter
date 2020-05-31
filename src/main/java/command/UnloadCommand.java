package command;

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
    public void execute()
    {
        container.removeDb(dbName);
    }
}
