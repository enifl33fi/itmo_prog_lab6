package network.requests;

import commands.CommandType;

public class HelpRequest extends Request {
    public HelpRequest(){
        super(CommandType.HELP);
    }
    @Override
    public Request get(boolean fromFile){
        return this;
    }
}
