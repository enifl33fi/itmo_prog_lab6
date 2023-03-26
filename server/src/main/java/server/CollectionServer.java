package server;

import java.io.IOException;

import java.net.ServerSocket;

import java.net.Socket;
import java.net.SocketException;
import java.util.Arrays;

import network.Request;
import network.Response;

public class CollectionServer {
    
    private final int port;
    private final ShittyServerSocketChannel servChannel = new ShittyServerSocketChannel();

    public CollectionServer(int port){
        this.port = port;
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
            }

        } catch (IOException e) {
            System.out.println("can't create server");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
    public Response getResponse(Request req){
        Response res = new Response();
        if (!req.hasData()){
            res.setResponseLine("Don't have required data.");
        }else {
            int[] ans = req.getData();
            res.setResponseLine("Got array: " + Arrays.toString(ans));
            for (int i = 0; i < ans.length; i++){
                ans[i] *= 2;
            }
            res.setData(ans);
        }
        return res;
    }

    public void getReqSendRes(Socket client) throws IOException {
        try {
            Request req = this.servChannel.getRequest(client);
            if (req != null){
                Response res = this.getResponse(req);
                this.servChannel.sendResponse(client, res);
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