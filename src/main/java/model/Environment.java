package model;

import java.util.List;

public class Environment
{
    private DBContainer container;
    private List<String> history;

    public Environment(DBContainer container, List<String> history)
    {
        this.container = container;
        this.history = history;
    }

    public DBContainer getContainer()
    {
        return container;
    }

    public List<String> getHistory()
    {
        return history;
    }
}
