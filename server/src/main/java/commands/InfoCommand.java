package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public class InfoCommand extends Command {
    public InfoCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description =
                "info : print information about the collection (type, initialization date, number of items, etc.) in the standard output.";
        this.commandType = CommandType.INFO;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Can't get information about the collection");
        if (!req.hasArg() && !req.hasElement()){
            res.setResponseLine(String.format("Information about the collection:%n%s", this.curCol.info()));
        }
        return res;
    }
}