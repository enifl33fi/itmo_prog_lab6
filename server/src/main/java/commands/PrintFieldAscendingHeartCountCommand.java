package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public class PrintFieldAscendingHeartCountCommand extends Command {
    public PrintFieldAscendingHeartCountCommand(InteractiveCollection curCol) {
        super(curCol);
        this.description =
                "print_field_ascending_heart_count : print the heartCount values of all elements in ascending order";
        this.commandType = CommandType.PRINT_FIELD_ASCENDING_HEART_COUNT;
    }

    @Override
    public Response execute(Request req) {
        Response res = new Response("Incorrect response. Can't get heartCount values");
        if (!req.hasArg() && !req.hasElement()){
            res.setResponseLine(String.format("HeartCount values of all elements in ascending order:%n%s", this.curCol.printFieldAscendingHeartCount()));
        }
        return res;
    }
}
