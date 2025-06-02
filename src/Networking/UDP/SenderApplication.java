package Networking.UDP;

public class SenderApplication implements Runnable{
    @Override
    public void run() {
        SenderCLient senderCLient = new SenderCLient(9990,"127.0.0.1",9999);
        senderCLient.start();
    }
}
