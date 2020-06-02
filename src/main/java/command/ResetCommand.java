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
