package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public class FilterContainsNameCommand extends Command {

    public FilterContainsNameCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description =
                "filter_contains_name name : output the elements whose name field value contains the specified substring";
        this.commandType = CommandType.FILTER_CONTAINS_NAME;
    }


    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Can't filter elements whose name field value contains the specified substring.");
        if (req.hasArg() && !req.hasElement()){
            res.setResponseLine(String.format("Elements whose name field value contains substring %s:%n%s", req.getArg(), this.curCol.filterContainsName(req.getArg())));
        }
        return res;
    }
}
