package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public class ShowCommand extends Command {
    public ShowCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description =
                "show : print all items of the collection as string output in the standard output";
        this.commandType = CommandType.SHOW;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Can't show elements.");
        if (!req.hasArg() && !req.hasElement()){
            res.setResponseLine(String.format("Elements in this collection:%n%s", this.curCol.show()));
        }
        return res;
    }
}
