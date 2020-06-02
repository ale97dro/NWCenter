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

public class ExitCommand implements Command
{
    @Override
    public Formatter execute()
    {
        return new ExitFormatter();
    }
}
