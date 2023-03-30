package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;


public class HeadCommand extends Command {
    public HeadCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description = "head : display the first element in the collection";
        this.commandType = CommandType.HEAD;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Can't get head of the collection");
        if (!req.hasArg() && !req.hasElement()){
            res.setResponseLine(String.format("Head of current collection:%n%s", this.curCol.head()));
        }
        return res;
    }
}
