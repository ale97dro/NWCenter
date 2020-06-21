/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.ExitFormatter;
import formatter.Formatter;

/**
 * Exit the program after the user request it.
 *
 * @author Alessandro Bianchi
 * @since v1.0
 */
public class ExitCommand implements Command
{
    /**
     * Perform the exit command.
     * @return {@link formatter.ExitFormatter} to handle the exit output.
     *
     * @since v1.0
     */
    @Override
    public Formatter execute()
    {
        return new ExitFormatter();
    }
}
