package network.requests;

import commands.CommandType;
import element.AstartesCategory;

public class CountByCategoryRequest extends Request {
    public CountByCategoryRequest(){
        super(CommandType.COUNT_BY_CATEGORY);
    }
    @Override
    public Request get(boolean fromFile, String arg){
        AstartesCategory.valueOf(arg);
        this.setArg(arg);
        return this;
    }
}
