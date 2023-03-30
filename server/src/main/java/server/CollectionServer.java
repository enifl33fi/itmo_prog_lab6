package server;

import java.io.IOException;

import java.net.ServerSocket;

import java.net.Socket;
import java.net.SocketException;

import commands.CommandType;
import managers.CommandManager;
import network.requests.Request;
import network.Response;

public class CollectionServer {

    private final int port;
    private final CommandManager commandManager;
    private final ShittyServerSocketChannel servChannel = new ShittyServerSocketChannel();


    public CollectionServer(int port, CommandManager commandManager){
        this.port = port;
        this.commandManager = commandManager;
    }

    public void run(){
        try(ServerSocket cs = new ServerSocket(this.port)){
            this.servChannel.setServer(cs);
            while (true){
                try {
                    this.servChannel.acceptClient();
                }catch (IOException e){
                    System.out.println("error while accepting client");
                }
                for (Socket curClient: servChannel.getClients()){
                    try {
                        this.getReqSendRes(curClient);
                    } catch (IOException e){
                        System.out.println("Unable to close client: " + e.getMessage());
                    }
                }
                if (this.servChannel.getToDelete().size() > 0){
                    this.servChannel.removeAll(this.servChannel.getToDelete());
                    this.servChannel.getToDelete().clear();
                }
            }

        } catch (IOException e) {
            System.out.println("can't create server");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
    public Response getResponse(Request req){
        Response res = this.commandManager.getCommand(req.getCommandType()).execute(req);
        return res;
    }

    public void getReqSendRes(Socket client) throws IOException {
        try {
            Request req = this.servChannel.getRequest(client);
            if (req != null){
                Response res = this.getResponse(req);
                this.servChannel.sendResponse(client, res);
                if (res.getCommandType() == CommandType.EXIT){
                    client.close();
                    this.servChannel.getToDelete().add(client);
                }
            }


        } catch (SocketException e){
            client.close();
            this.servChannel.removeClient(client);
            System.out.println("Problems in client: " + e.getMessage());
        }catch (IOException e){
            client.close();
            this.servChannel.removeClient(client);
            System.out.println("Unexpected error while reading");
        }
    }


}