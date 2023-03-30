package network.requests;

import commands.CommandType;

public class ClearRequest extends Request {

    public ClearRequest(){
        super(CommandType.CLEAR);
    }
    @Override
    public Request get(boolean fromFile){
        return this;
    }
}
