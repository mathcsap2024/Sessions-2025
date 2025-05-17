package Networking.Client;

import Networking.Message;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientUser extends Thread{
    String IP;
    int port;

    Socket socket;
    Scanner inputScanner, socketScanner;
    PrintStream outputWriter, socketWriter;

    String userName;
    ClientReadThread readThread;

    public ClientUser(String IP, int port) throws IOException {
        this.IP=IP;
        this.port=port;
        socket = new Socket(IP, port);
    }

    class ClientReadThread extends Thread{
        @Override
        public void run() {
            super.run();

            String line = socketScanner.nextLine();
            outputWriter.println(line);
            outputWriter.flush();
        }
    }

    @Override
    public void run() {
        super.run();

        try {
            inputScanner = new Scanner(System.in);
            outputWriter = System.out;

            socketScanner = new Scanner(socket.getInputStream());
            socketWriter = new PrintStream(socket.getOutputStream());

            register();

            readThread = new ClientReadThread();
            readThread.start();

            while (socket.isConnected()) {
                sendMessage(getMessage());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    void sendMessage(Message message) {
        socketWriter.println(message.getDestination()+":"+message.getMessage());
        socketWriter.flush();
    }

    Message getMessage() {
        outputWriter.println("Whom to do you want to send message?");
        String destination = inputScanner.nextLine();
        outputWriter.println("Enter the message: ");
        String message = inputScanner.nextLine();

        return new Message(userName, destination, message);
    }

    void register() {
        userName = inputScanner.nextLine();
        socketWriter.println(userName);
    }
}
