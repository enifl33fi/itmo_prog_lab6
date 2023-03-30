package server;

import collection.CollectionGenerator;
import managers.CommandLoader;
import managers.ObjectsKeeper;
import managers.CommandManager;

public class Main {


    public static void main(String[] args) {
        CollectionGenerator collectionGenerator = new CollectionGenerator();
        ObjectsKeeper objectsKeeper = new ObjectsKeeper();
        CommandManager commandManager = objectsKeeper.getCommandManager();
        CommandLoader commandLoader = new CommandLoader(commandManager);
        commandLoader.load(objectsKeeper.getCurCol());
        collectionGenerator.generateFromCSV(objectsKeeper.getCurCol());

        new CollectionServer(4569, commandManager).run();
    }

}
