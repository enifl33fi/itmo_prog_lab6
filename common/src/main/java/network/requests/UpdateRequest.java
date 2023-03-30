package network.requests;

import commands.CommandType;
import element.ElementParser;
import element.ElementValidator;
import inputWorkers.InputHandler;

public class UpdateRequest extends Request {
    private final transient ElementParser elementParser = new ElementParser();
    private final transient InputHandler inputHandler;
    private final transient ElementValidator elementValidator = new ElementValidator();

    public UpdateRequest(InputHandler inputHandler){
        super(CommandType.UPDATE);
        this.inputHandler = inputHandler;

    }
    @Override
    public Request get(boolean fromFile, String arg){
        Long.parseLong(arg);
        this.setArg(arg);
        if (fromFile){
            this.setElement(elementValidator.validateSpaceMarine(inputHandler.readElem()));
        } else{
            this.setElement(elementParser.parseElement());
        }
        return this;
    }
}
