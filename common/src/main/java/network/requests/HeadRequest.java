package network.requests;

import commands.CommandType;

public class HeadRequest extends Request {
    public HeadRequest(){
        super(CommandType.HEAD);
    }
    @Override
    public Request get(boolean fromFile){
        return this;
    }
}
