package Networking.Client;

import java.io.IOException;

public class Application implements Runnable{
    @Override
    public void run() {
        try {
            ClientUser client = new ClientUser("127.0.0.1",6000);
            client.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
