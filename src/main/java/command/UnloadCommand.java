/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.Formatter;
import model.DBContainer;

/**
 * Unload a database from the container and delete the associated logs.
 *
 * @author Alessandro Bianchi
 * @since v1.0
 */
public class UnloadCommand implements Command
{
    private DBContainer container;
    private String dbName;

    /**
     * Public constructor for UnloadCommand.
     * @param dbName The database to remove from the container.
     * @param container The container of databases that contains the database to remove.
     *
     * @since v1.0
     */
    public UnloadCommand(String dbName, DBContainer container)
    {
        this.container = container;
        this.dbName = dbName;
    }

    /**
     * Remove the database from the container.
     * @return null: no output needed.
     */
    @Override
    public Formatter execute()
    {
        container.removeDb(dbName);
        return null;
    }
}
