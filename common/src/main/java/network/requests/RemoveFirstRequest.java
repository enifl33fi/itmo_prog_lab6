package network.requests;

import commands.CommandType;

public class RemoveFirstRequest extends Request {
    public RemoveFirstRequest(){
        super(CommandType.REMOVE_FIRST);
    }
    @Override
    public Request get(boolean fromFile){
        return this;
    }
}
