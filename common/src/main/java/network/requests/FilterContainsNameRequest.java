package network.requests;

import commands.CommandType;

public class FilterContainsNameRequest extends Request {
    public FilterContainsNameRequest(){
        super(CommandType.FILTER_CONTAINS_NAME);
    }
    @Override
    public Request get(boolean fromFile, String arg){
        this.setArg(arg);
        return this;
    }
}
