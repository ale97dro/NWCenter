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

public class ClearCommand implements Command
{
    private String os;

    public ClearCommand(String os)
    {
        this.os = os;
    }

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
