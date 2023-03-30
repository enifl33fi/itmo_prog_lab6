package commands;


import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public class AddCommand extends Command {
    public AddCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description = "add {element} : add a new element to the collection";
        this.commandType = CommandType.ADD;
    }


    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Add failed.");
        if (req.hasElement() && !req.hasArg()){
            this.curCol.add(req.getElement());
            res.setResponseLine("Element was successfully added.");
        }
        return res;
    }
}
