package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public class RemoveFirstCommand extends Command {
    public RemoveFirstCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description = "remove_first : remove the first item in the collection";
        this.commandType = CommandType.REMOVE_FIRST;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Can't remove first element from the collection");
        if (!req.hasArg() && !req.hasElement()){
            res.setResponseLine(this.curCol.removeFirst() + "\n");
        }
        return res;


    }
}
