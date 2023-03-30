package client;

import general.GeneralVars;
import inputWorkers.InputHandler;
import managers.ObjectsKeeper;
import managers.RequestLoader;
import managers.RequestManager;

public class Main {
    public static void main(String[] args) {
        ObjectsKeeper objectsKeeper = new ObjectsKeeper();
        GeneralVars generalVars = new GeneralVars();
        InputHandler inputHandler = generalVars.getInputHandler();
        RequestManager requestManager = objectsKeeper.getRequestManager();
        RequestLoader requestLoader = new RequestLoader(requestManager, inputHandler);
        requestLoader.load();

        new Client(requestManager, inputHandler).run("localhost", 4569);
    }
}
