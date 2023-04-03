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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class Client {
    private static final Logger LOGGER= LogManager.getLogger(Client.class);
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

    private SocketChannel connect(String host, int port){
        while (true){
            try {
                SocketChannel openChannel = SocketChannel.open();
                InetSocketAddress address = new InetSocketAddress(host, port);
                if (!address.isUnresolved()) {
                    openChannel.connect(address);
                    LOGGER.info(String.format("Connected with server: host: %s port: %d%n", host, port));
                    openChannel.configureBlocking(false);
                    this.host = host;
                    this.port = port;
                    return openChannel;
                }
            } catch (IOException ignored){

            }
        }

    }
    public void run(String host, int port){
        try (SocketChannel newChannel = this.connect(host, port)) {
            this.channel = newChannel;
            while (this.channel != null){
                Response res = this.sendReqGetRes();
                if (res != null){
                    System.out.println(res.getResponseLine());
                    if (res.isExit()){
                        System.exit(0);
                    }
                }
            }
        } catch (IOException e) {
            LOGGER.fatal(e.getMessage());
            LOGGER.fatal("Server went into hibernation or programmers messed up again");
        }

    }

    public Request getRequest(){
        while (true){
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
                    LOGGER.error(e.getMessage());
                } catch (IllegalArgumentException e) {
                    LOGGER.error(e.getMessage());
                    LOGGER.error("Wrong argument");
                } catch (NullPointerException | IndexOutOfBoundsException e) {
                    LOGGER.error("Unknown command");
                }
            }
        }
    }

    public void sendRequest(Request req) throws IOException, InterruptedException {
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
        if (remainAttempts <= 0){
            throw new TimeLimitException();
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
        throw new TimeLimitException();
    }

    public Response sendReqGetRes(){
        Request req = this.getRequest();
        try {
            this.sendRequest(req);
            return this.getResponse();
        } catch (IOException e) {
            LOGGER.error("Failed to exchange data with server");
            this.channel = this.reconnect();
        } catch (InterruptedException e) {
            LOGGER.error(e.getMessage());
        } catch (TimeLimitException e){
            LOGGER.error(e.getMessage());
            this.channel = this.reconnect();
        }
        return null;
    }

    public SocketChannel reconnect(){
        return this.connect(this.host, this.port);

    }

}