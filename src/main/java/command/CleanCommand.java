package command;

import console.ConsolePrinter;
import formatter.Formatter;

public class CleanCommand implements Command
{
    //private ConsolePrinter writer;

    public CleanCommand()
    {
        //this.writer = writer;
    }

    @Override
    public Formatter execute()
    {
        //out.print("\033[H\033[2J");
        //out.flush();

//        writer.print("\033[H\033[2J");
//       writer.flush();

       return null;
    }
}
