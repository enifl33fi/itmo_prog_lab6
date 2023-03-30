package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public class RemoveByIdCommand extends Command {
    public RemoveByIdCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description = "remove_by_id id : remove an item from the collection by its id";
        this.commandType = CommandType.REMOVE_BY_ID;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Can't remove by id.");
        if (req.hasArg() && !req.hasElement()){
            res.setResponseLine(this.curCol.removeById(Long.parseLong(req.getArg())));
        }
        return res;
    }
}
