package network.requests;

import commands.CommandType;

public class InfoRequest extends Request {
    public InfoRequest(){
        super(CommandType.INFO);
    }
    @Override
    public Request get(boolean fromFile){
        return this;
    }
}
