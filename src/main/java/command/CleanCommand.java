/*
 * ---------------------------------------------------------------------------------------------
 *  *  Copyright (c) 2020 Alessandro Bianchi
 *  *  Licensed under the MIT License. See LICENSE in the project root for license information.
 *  * github.com/ale97dro/NWCenter
 *  *--------------------------------------------------------------------------------------------
 */

package command;

import formatter.Formatter;

import java.io.IOException;

public class CleanCommand implements Command
{
    //private ConsolePrinter writer;
    private String os;

    public CleanCommand(String os)
    {
        //this.writer = writer;
        this.os = os;
    }

    @Override
    public Formatter execute()
    {
        //out.print("\033[H\033[2J");
        //out.flush();

//        writer.print("\033[H\033[2J");
//       writer.flush();

        if(os.toUpperCase().contains("WINDOWS"))
        {
            try
            {
                //Runtime.getRuntime().exec("cls");

                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
            catch (IOException | InterruptedException e)
            {
                //e.printStackTrace();
            }

            return null;
        }

        //todo: create formatter and return the string to print
        return null;

    }
}
