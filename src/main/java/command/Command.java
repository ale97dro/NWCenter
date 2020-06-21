/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.Formatter;

/**
 * Provides a common interface to describe how to execute commands.
 *
 * @author Alessandro Bianchi
 * @since v1.0
 */
public interface Command
{
    /**
     * Execute a command and return a new {@link formatter.Formatter} to handle the result of execution.
     * @return a new {@link formatter.Formatter}
     */
    Formatter execute();
}
