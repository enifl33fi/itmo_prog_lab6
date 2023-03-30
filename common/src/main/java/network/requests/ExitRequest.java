package network.requests;

import commands.CommandType;

public class ExitRequest extends Request{
    public ExitRequest(){
        super(CommandType.EXIT);
    }
    @Override
    public Request get(boolean fromFile){
        return this;
    }
}
