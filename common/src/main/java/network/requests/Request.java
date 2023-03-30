package network.requests;

import commands.CommandType;
import element.CollectionPart;
import exceptions.WrongCommandException;

import java.io.Serializable;

public class Request implements Serializable {
    private CommandType commandType;
    private CollectionPart element;
    private String arg;

    public Request(CommandType commandType){
        this.commandType = commandType;
    }


    public CommandType getCommandType() {
        return this.commandType;
    }

    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }

    public CollectionPart getElement() {
        return element;
    }

    public void setElement(CollectionPart element) {
        this.element = element;
    }

    public String getArg() {
        return arg;
    }

    public void setArg(String arg) {
        this.arg = arg;
    }

    public boolean hasElement(){
        return this.element != null;
    }

    public boolean hasArg(){
        return this.arg != null;
    }

    public Request get(boolean fromFile){
        throw new WrongCommandException();
    }

    public Request get(boolean fromFile, String arg){
        throw new WrongCommandException();
    }
}
