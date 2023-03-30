package client;

import commands.CommandType;
import exceptions.NullFieldException;
import exceptions.TimeLimitException;
import exceptions.WrongCommandException;
import exceptions.WrongFieldException;
import inputWorkers.InputHandler;
import inputWorkers.RequestParser;
import managers.RequestManager;
import network.requests.Request;
import network.Response;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class Client {
    private SocketChannel channel;
    private String host;
    private int port;
    private final InputHandler inputHandler;

    private final RequestParser requestParser;

    private final int attemptsCount  = 30;
    private final int clientSleepTime = 20;


    public Client(RequestManager requestManager, InputHandler inputHandler) {
        this.requestParser = new RequestParser(requestManager);
        this.inputHandler = inputHandler;

    }

    private SocketChannel connect(String host, int port) throws IOException {
        SocketChannel openChannel = SocketChannel.open();
        InetSocketAddress address = new InetSocketAddress(host, port);
        if (!address.isUnresolved()){
            openChannel.connect(address);
            System.out.printf("Connected with server: host: %s port: %d%n", host, port);
            openChannel.configureBlocking(false);
            this.host = host;
            this.port = port;
            return openChannel;
        }
        return null;
    }
    public void run(String host, int port){
        try (SocketChannel newChannel = this.connect(host, port)) {
            this.channel = newChannel;
            while (this.channel != null){
                Response res = this.sendReqGetRes();
                if (res == null){
                    System.out.println("Server went into hibernation or programmers messed up again");
                    System.exit(0);
                }
                System.out.println(res.getResponseLine());
                if (res.isExit()){
                    System.exit(0);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("fail");
        }
        System.out.println("Server went into hibernation or programmers messed up again");

    }

    public Request getRequest(){
        while (true){
            System.out.println("собираю реквест");
            String lineArr = this.inputHandler.getLine();
            if (lineArr != null){
                try{
                    Request req =  this.requestParser.parse(lineArr, this.inputHandler.isFromFile());
                    if (req.getCommandType() == CommandType.EXECUTE_SCRIPT){
                        this.inputHandler.setFromFile(true);
                        this.inputHandler.getCommands(req.getArg());
                    } else {
                        return req;
                    }
                }catch (WrongFieldException | NullFieldException | WrongCommandException e) {
                    System.out.println(e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Wrong argument");
                } catch (NullPointerException | IndexOutOfBoundsException e) {
                    System.out.println("Unknown command");
                }
            }
        }
    }

    public void sendRequest(Request req) throws IOException, InterruptedException {
        System.out.println("посылаю реквест");
        int remainAttempts = this.attemptsCount;
        ByteBuffer bf = ByteBuffer.wrap(SerializationUtils.serialize(req));
        while (remainAttempts > 0){
            int state = this.channel.write(bf);
            if (state == -1){
                remainAttempts--;
                TimeUnit.MILLISECONDS.sleep(this.clientSleepTime);
            }
            else {
                break;
            }
        }
    }

    public Response getResponse() throws IOException, InterruptedException {
        int remainAttempts = this.attemptsCount;
        ByteBuffer bf = ByteBuffer.allocate(2048);
        while (remainAttempts > 0){
            int state = this.channel.read(bf);
            if (state == -1 || state == 0){
                remainAttempts--;
                TimeUnit.MILLISECONDS.sleep(this.clientSleepTime);
            }
            else{
                return SerializationUtils.deserialize(bf.array());


            }
        }
        return null;
    }

    public Response sendReqGetRes(){
        Request req = this.getRequest();
        try {
            this.sendRequest(req);
            return this.getResponse();
        } catch (IOException e) {
            System.out.println("Failed to exchange data with server");
            System.exit(0);
            this.channel = this.reconnect();
        } catch (InterruptedException e) {
            System.out.println("why");;
        } catch (TimeLimitException e){
            System.out.println(e.getMessage());
            System.exit(0);
        }
        return null;
    }

    public SocketChannel reconnect(){
        try{
            return this.connect(this.host, this.port);
        } catch (IOException e) {
            return null;
        }
    }

}