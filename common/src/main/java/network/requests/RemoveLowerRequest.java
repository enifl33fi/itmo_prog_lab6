package network.requests;

import commands.CommandType;
import element.ElementParser;
import element.ElementValidator;
import inputWorkers.InputHandler;

public class RemoveLowerRequest extends Request {
    private final transient ElementParser elementParser = new ElementParser();
    private final transient InputHandler inputHandler;
    private final transient ElementValidator elementValidator = new ElementValidator();

    public RemoveLowerRequest(InputHandler inputHandler){
        super(CommandType.REMOVE_LOWER);
        this.inputHandler = inputHandler;

    }

    @Override
    public Request get(boolean fromFile){
        if (fromFile){
            this.setElement(elementValidator.validateSpaceMarine(inputHandler.readElem()));
        } else{
            this.setElement(elementParser.parseElement());
        }
        return this;
    }
}
