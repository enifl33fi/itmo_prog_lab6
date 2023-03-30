package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

/** Class using for executing remove_lower command.
 * @author Kirill Markov
 * @version 1.0*/
public class RemoveLowerCommand extends Command {
    public RemoveLowerCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description =
                "remove_lower {element} : remove all elements from the collection that are smaller than the given one";
        this.commandType = CommandType.REMOVE_LOWER;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Add failed.");
        if (req.hasElement() && !req.hasArg()){
            res.setResponseLine(this.curCol.removeLower(req.getElement()));
        }
        return res;
    }

}

