package model;

import console.ConsoleWriter;

import java.util.List;

public class Environment
{
    private DBContainer container;
    private ConsoleWriter writer;
    private List<String> history;

    public Environment(DBContainer container, ConsoleWriter writer, List<String> history)
    {
        this.container = container;
        this.writer = writer;
        this.history = history;
    }

    public DBContainer getContainer()
    {
        return container;
    }

    public ConsoleWriter getWriter()
    {
        return writer;
    }

    public List<String> getHistory()
    {
        return history;
    }
}
