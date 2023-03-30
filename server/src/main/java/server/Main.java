package server;

import collection.CollectionGenerator;
import collection.InteractiveCollection;
import managers.CommandLoader;
import managers.ObjectsKeeper;
import managers.CommandManager;

public class Main {


    public static void main(String[] args) {
        CollectionGenerator collectionGenerator = new CollectionGenerator();
        ObjectsKeeper objectsKeeper = new ObjectsKeeper();
        CommandManager commandManager = objectsKeeper.getCommandManager();
        CommandLoader commandLoader = new CommandLoader(commandManager);
        InteractiveCollection curCol = objectsKeeper.getCurCol();
        commandLoader.load(curCol);
        collectionGenerator.generateFromCSV(objectsKeeper.getCurCol());

        new CollectionServer(4569, commandManager, curCol).run();
    }

}
