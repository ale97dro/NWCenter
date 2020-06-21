/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.Formatter;
import formatter.HistoryFormatter;

import java.util.List;

/**
 * Show the history of the commands submitted by the user during the execution of the application.
 *
 * @author Alessandro Bianchi
 * @since v1.0
 */
public class HistoryCommand implements Command
{
    private List<String> history;

    /**
     * Public constructor for HistoryCommand
     * @param history List of strings that contains all the commands submitted by the user during the current session of the application.
     *
     * @since v1.0
     */
    public HistoryCommand(List<String> history)
    {
        this.history = history;
    }

    /**
     * Create a formatter in order to print the history of the application's commands.
     * @return {@link formatter.HistoryFormatter} to handle the history output.
     *
     * @since v1.0
     */
    @Override
    public Formatter execute()
    {
        return new HistoryFormatter(history);
    }
}
