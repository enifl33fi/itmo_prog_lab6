package client;

import inputWorkers.InputHandler;
import network.Request;
import network.Response;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Client {
    private SocketChannel channel;
    private String host;
    private int port;
    private final InputHandler inputHandler = new InputHandler();

    private final int attemptsCount  = 30;
    private final int clientSleepTime = 20;

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
            if (newChannel != null){
                this.channel = newChannel;
            }
            while (this.channel != null){
                Response res = this.sendReqGetRes();
                System.out.println(res.getResponseLine());
            }
        } catch (IOException e) {
            System.out.println("fail");
        }

    }

    public Request getRequest(){
        System.out.println("собираю реквест");
        String lineArr = inputHandler.getLine();
        Request req = new Request();
        try{
            req.setData(Arrays.stream(lineArr.split(" ")).mapToInt(Integer::parseInt).toArray());
        } catch (Exception ignored){
            System.out.println("Shitty data");
        }

        return req;
    }

    public void sendRequest(Request req) throws IOException {
        System.out.println("посылаю реквест");
        ByteBuffer bf = ByteBuffer.wrap(SerializationUtils.serialize(req));
        this.channel.write(bf);
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
            this.channel = this.reconnect();
        } catch (InterruptedException e) {
            System.out.println("why");;
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
