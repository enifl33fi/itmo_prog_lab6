package commands;

import managers.CommandManager;
import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public class HelpCommand extends Command {
    private final CommandManager commandManager;

    public HelpCommand(InteractiveCollection curCol, CommandManager commandManager) {
        super(curCol);
        this.description = "help : print help for available commands";
        this.commandType = CommandType.HELP;
        this.commandManager = commandManager;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Can't show help");
        if (!req.hasArg() && !req.hasElement()){
            res.setResponseLine(this.commandManager.getCommandsDescr() + "\n");
        }
        return res;
    }
}