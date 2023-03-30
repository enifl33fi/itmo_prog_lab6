package network.requests;

import commands.CommandType;

public class ShowRequest extends Request {
    public ShowRequest(){
        super(CommandType.SHOW);
    }
    @Override
    public Request get(boolean fromFile){
        return this;
    }
}
