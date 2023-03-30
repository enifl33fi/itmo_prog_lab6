package managers;

public class ObjectsKeeper {
    private final RequestManager requestManager = new RequestManager();

    public RequestManager getRequestManager(){
        return this.requestManager;
    }
}
