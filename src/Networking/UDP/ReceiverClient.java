package Networking.UDP;

import APLogger.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class ReceiverClient extends Thread {
    int port;

    private static int MAX_LENGTH=1000;

    public ReceiverClient(int port) {
        this.port=port;
    }
    @Override
    public void run() {
        super.run();

        try {
            DatagramSocket datagramSocket = new DatagramSocket(port);

            byte[] data = new byte[MAX_LENGTH];
            DatagramPacket datagramPacket = new DatagramPacket(data, MAX_LENGTH);
            datagramSocket.receive(datagramPacket);
            Logger.getInstance().log("Received a message from "+datagramPacket.getAddress(), Logger.Level.INFO);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            Object object = objectInputStream.readObject();

            Logger.getInstance().log("The toString value of object is: "+object.toString(), Logger.Level.INFO);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
