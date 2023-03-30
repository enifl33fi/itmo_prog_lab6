package commands;

import collection.InteractiveCollection;
import element.AstartesCategory;
import network.Response;
import network.requests.Request;

public class CountByCategoryCommand extends Command {
    public CountByCategoryCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description =
                "count_by_category category : output the number of elements with a category value equal to the given one";
        this.commandType = CommandType.COUNT_BY_CATEGORY;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Can't count by category.");
        if (req.hasArg() && !req.hasElement()){
            int count = this.curCol.countByCategory(AstartesCategory.valueOf(req.getArg()));
            res.setResponseLine(String.format("Count of %s category - %d%n", req.getArg(), count));
        }
        return res;
    }
}