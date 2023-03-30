package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public class UpdateCommand extends Command {

    public UpdateCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description =
                "update id {element} : update the value of an element in the collection whose id is equal to the given one";
        this.commandType = CommandType.UPDATE;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Update failed.");
        if (req.hasElement() && req.hasArg()){
            res.setResponseLine(this.curCol.update(Long.parseLong(req.getArg()), req.getElement()));
        }
        return res;
    }
}