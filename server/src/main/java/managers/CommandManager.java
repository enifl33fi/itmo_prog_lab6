package managers;

import commands.Command;
import commands.CommandType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CommandManager {
    private final HashMap<CommandType, Command> data = new HashMap<>();
    private final List<Command> commandList = new ArrayList<>();

    public void addCommand(Command command) {
        this.data.put(command.getCommandType(), command);
        this.commandList.add(command);
    }

    public void removeCommand(CommandType key) {
        this.data.remove(key);
    }

    public Command getCommand(CommandType key) {
        return this.data.get(key);
    }

    public String getCommandsDescr() {
        StringBuilder answer = new StringBuilder();
        for (Command command : commandList) {
            answer.append(command.getDescription()).append("\n");
        }
        return answer.toString();
    }
}

