/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.Formatter;
import logparser.LogParser;
import model.DBContainer;
import model.LogDB;

/**
 * Load a new log file from filesystem, parse it and add the new database to the database container
 *
 * @author Alessandro Bianchi
 * @since v1.0
 */
public class LoadCommand implements Command
{
    private String path;
    private DBContainer container;

    /**
     * Public constructor for LoadCommand.
     * @param path The path of the logs file.
     * @param container Specify the database container where you want to add the new logs database.
     *
     * @since v1.0
     */
    public LoadCommand(String path, DBContainer container)
    {
        this.path = path;
        this.container = container;
    }

    /**
     * Load the file in the application and read it.
     * Perform a parse using {@link logparser.LogParser} in order to extract the logs. Create a new {@link model.LogDB} and add it to the {@link model.DBContainer}.
     * @return null: no output is requested.
     *
     * @since v1.0
     */
    @Override
    public Formatter execute()
    {
        LogDB db = LogParser.parse(path);
        container.addDb(db);

        return null;
    }
}
