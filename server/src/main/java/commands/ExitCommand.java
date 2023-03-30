package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public class ExitCommand extends Command {
    public ExitCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description = "exit : end the program (without saving it to a file)";
        this.commandType = CommandType.EXIT;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Can't exit an app.");
        if (!req.hasArg() && !req.hasElement()){
            res.setExit(true);
            res.setResponseLine("bye bye");
        }
        return res;
    }
}
