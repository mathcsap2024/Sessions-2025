package Networking.UDP;

import University.Point;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class SenderCLient extends Thread{
    int port;
    int remotePort;
    String remoteAddress;

    private static int MAX_LENGTH=1000;

    public SenderCLient(int port, String remoteAddress, int remotePort) {
        this.remoteAddress=remoteAddress;
        this.remotePort=remotePort;
        this.port=port;
    }

    @Override
    public void run() {
        super.run();

        try {
            DatagramSocket datagramSocket = new DatagramSocket(port);

            Point point = new Point(19,34);
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream(MAX_LENGTH);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(point);

            DatagramPacket datagramPacket = new DatagramPacket(
                    byteArrayOutputStream.toByteArray(),
                    byteArrayOutputStream.size(),
                    new InetSocketAddress(remoteAddress, remotePort)
            );
            datagramSocket.send(datagramPacket);
        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
