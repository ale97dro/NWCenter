package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DBContainer
{
    private List<LogDB> dbs;

    public DBContainer()
    {
        dbs = new ArrayList<>();
    }

    public void addDb(LogDB db)
    {
        dbs.add(db);
    }

    public LogDB removeDb(String name)
    {
        Iterator<LogDB> iterator = dbs.iterator();

        while(iterator.hasNext())
        {
            LogDB db = iterator.next();
            if (db.getName().equals(name))
            {
                iterator.remove();
                return db;
            }
        }

        return null;
    }

    public LogDB getDb(String name)
    {
        for (LogDB db : dbs)
        {
            if (db.getName().equals(name))
                return db;
        }

        return null;
    }

    public List<LogDB> getAllDbs()
    {
        return dbs;
    }
}
