package network.requests;

import commands.CommandType;

public class RemoveByIdRequest extends Request{
    public RemoveByIdRequest(){
        super(CommandType.REMOVE_BY_ID);
    }
    @Override
    public Request get(boolean fromFile, String arg){
        Long.parseLong(arg);
        this.setArg(arg);
        return this;
    }
}
