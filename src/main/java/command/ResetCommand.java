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

/**
 * Rollback the application to its initial state: clean up history and databases container.
 *
 * @author Alessandro Bianchi
 * @since v1.0
 */
public class ResetCommand implements Command
{
    private Environment environment;

    /**
     * public constructor for ResetCommand
     * @param environment Provides the {@link model.Environment} of the application.
     *
     * @since v1.0
     */
    public ResetCommand(Environment environment)
    {
        this.environment = environment;
    }

    /**
     * Perform the reset of the application: clear history and container
     * @return null: no output requested.
     *
     * @since v1.0
     */
    @Override
    public Formatter execute()
    {
        environment.getHistory().clear();
        environment.getContainer().clear();

        return null;
    }
}
