/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.ClearFormatter;
import formatter.Formatter;

import java.io.IOException;

/**
 * Clean the console from previous output messages.
 * Two OS are supported: Windows and Unix/Linux
 *
 * @author Alessandro Bianchi
 * @since v1.0
 */
public class ClearCommand implements Command
{
    private String os;

    /**
     * Public constructor for ClearCommand
     * @param os OS that host the application
     *
     * @since v1.0
     */
    public ClearCommand(String os)
    {
        this.os = os;
    }

    /**
     * Execute the command: perform a console clear.
     * The method implements two different logic, one for Windows and one for Linux.
     * Windows logic create a cmd process and launch a cls command.
     * Linux logic print a special string that allow to clean up the console.
     * @return {@link formatter.ClearFormatter} to print Linux characters. In case of Windows, return null.
     *
     * @since v1.0
     */
    @Override
    public Formatter execute()
    {
        //out.print("\033[H\033[2J");
        //out.flush();

        if(os.toUpperCase().contains("WINDOWS"))
        {
            try
            {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            catch (IOException | InterruptedException e)
            {

            }

            return null;
        }
        else
            return new ClearFormatter("\033[H\033[2J");
    }
}
