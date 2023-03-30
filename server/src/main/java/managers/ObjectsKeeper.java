package managers;

import collection.SpaceMarineCollection;

public class ObjectsKeeper {
    private final SpaceMarineCollection curCol = new SpaceMarineCollection();


    private final CommandManager commandManager = new CommandManager();
    public CommandManager getCommandManager() {
        return commandManager;
    }

    public SpaceMarineCollection getCurCol() {
        return curCol;
    }
}
