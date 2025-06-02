package Networking.UDP;

public class ReceiverApplication implements Runnable{
    @Override
    public void run() {
        ReceiverClient receiverClient=new ReceiverClient(9999);
        receiverClient.start();
    }
}
