package Networking.Server;

import java.io.IOException;

public class Application implements Runnable{

    @Override
    public void run() {
        try {
            Server server = new Server(6000);
            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
