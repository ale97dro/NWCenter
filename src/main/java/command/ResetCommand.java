/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.Formatter;
import model.Environment;

public class ResetCommand implements Command
{
    private Environment environment;

    public ResetCommand(Environment environment)
    {
        this.environment = environment;
    }

    @Override
    public Formatter execute()
    {
        environment.getHistory().clear();
        environment.getContainer().clear();

        return null;
    }
}
