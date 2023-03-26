package server;

import network.Request;
import network.Response;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.HashSet;

public class ShittyServerSocketChannel {
    private final int serverWaitTime = 100;
    private final HashSet<Socket> clients = new HashSet<>();
    private ServerSocket server;
    public ServerSocket getServer() {
        return this.server;
    }

    public void setServer(ServerSocket server) {
        this.server = server;
    }

    public void addClient(Socket client){
        this.clients.add(client);
    }

    public void removeClient(Socket client){
        this.clients.remove(client);
    }
    public HashSet<Socket> getClients(){
        return this.clients;
    }

    public Socket acceptClient() throws IOException {

        try {
            this.server.setSoTimeout(this.serverWaitTime);
            Socket client = this.server.accept();
            this.clients.add(client);
            return client;
        } catch (SocketTimeoutException e) {
            return null;
        }
    }

    public Request getRequest(Socket client) throws IOException {
        try {
            client.setSoTimeout(this.serverWaitTime);
            InputStream is = client.getInputStream();
            byte[] inData = new byte[2048];
            is.read(inData);
            Request req = SerializationUtils.deserialize(inData);
            return req;
        }catch (SocketTimeoutException e){
            return null;
        }
    }

    public void sendResponse(Socket client, Response res) throws IOException {
        OutputStream os = client.getOutputStream();
        byte[] outData = SerializationUtils.serialize(res);
        os.write(outData);

    }
}
