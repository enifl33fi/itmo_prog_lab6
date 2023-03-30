package managers;

import inputWorkers.InputHandler;
import network.requests.Request;
import network.requests.*;

public class RequestLoader {
    private final RequestManager requestManager;
    private final InputHandler inputHandler;

    public RequestLoader(RequestManager requestManager, InputHandler inputHandler) {
        this.requestManager = requestManager;
        this.inputHandler = inputHandler;
    }

    public void load() {
        Request addRequest = new AddRequest(this.inputHandler);
        Request clearRequest = new ClearRequest();
        Request countByCategoryRequest = new CountByCategoryRequest();
        Request exitRequest = new ExitRequest();
        Request filterContainsNameRequest = new FilterContainsNameRequest();
        Request headRequest = new HeadRequest();
        Request helpRequest = new HelpRequest();
        Request infoRequest = new InfoRequest();
        Request printFieldAscendingHeartCountRequest = new PrintFieldAscendingHeartCountRequest();
        Request removeByIdRequest = new RemoveByIdRequest();
        Request removeFirstRequest = new RemoveFirstRequest();
        Request removeLowerRequest = new RemoveLowerRequest(this.inputHandler);
        Request showRequest = new ShowRequest();
        Request updateRequest = new UpdateRequest(this.inputHandler);
        Request executeScriptRequest = new ExecuteScriptRequest();


        this.requestManager.addRequest(addRequest);
        this.requestManager.addRequest(clearRequest);
        this.requestManager.addRequest(countByCategoryRequest);
        this.requestManager.addRequest(exitRequest);
        this.requestManager.addRequest(filterContainsNameRequest);
        this.requestManager.addRequest(headRequest);
        this.requestManager.addRequest(helpRequest);
        this.requestManager.addRequest(infoRequest);
        this.requestManager.addRequest(printFieldAscendingHeartCountRequest);
        this.requestManager.addRequest(removeByIdRequest);
        this.requestManager.addRequest(removeFirstRequest);
        this.requestManager.addRequest(removeLowerRequest);
        this.requestManager.addRequest(showRequest);
        this.requestManager.addRequest(updateRequest);
        this.requestManager.addRequest(executeScriptRequest);
    }
}
