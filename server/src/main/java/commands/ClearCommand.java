package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public class ClearCommand extends Command {
    public ClearCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description = "clear : clear the collection";
        this.commandType = CommandType.CLEAR;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Can't clear.");
        if (!req.hasArg() && !req.hasElement()){
            this.curCol.clear();
            res.setResponseLine("Collection cleared successfully.");
        }
        return res;
    }
}