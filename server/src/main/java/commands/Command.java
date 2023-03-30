package commands;

import collection.InteractiveCollection;
import network.Response;
import network.requests.Request;

public abstract class Command {
    protected CommandType commandType;
    protected String description = null;
    protected InteractiveCollection curCol;

    public Command(InteractiveCollection curCol) {
        this.curCol = curCol;
    }

    public CommandType getCommandType() {
        return this.commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public abstract Response execute(Request req);

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}