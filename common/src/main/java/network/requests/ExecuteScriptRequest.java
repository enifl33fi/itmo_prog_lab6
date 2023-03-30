package network.requests;

import commands.CommandType;

public class ExecuteScriptRequest extends Request{
    public ExecuteScriptRequest(){
        super(CommandType.EXECUTE_SCRIPT);
    }
    @Override
    public Request get(boolean fromFile, String arg){
        this.setArg(arg);
        return this;
    }
}
