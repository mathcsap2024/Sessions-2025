package Networking.Server;

import APLogger.Logger;
import Networking.Message;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.TreeMap;

public class Server extends Thread{
    ServerSocket serverSocket;
    TreeMap<String, ServerUser> users;

    public class ServerUser extends Thread{
        Socket socket;
        Scanner scanner;
        PrintStream printStream;
        String username;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public ServerUser(Socket socket) throws IOException, AlreadyExistsException {
            this.socket = socket;
            scanner = new Scanner(socket.getInputStream());
            printStream = new PrintStream(socket.getOutputStream());

            register();
        }

        private void register() throws AlreadyExistsException {
            Logger.getInstance().log(
                    "Registering user with address "+socket.getRemoteSocketAddress().toString(),
                    Logger.Level.INFO
            );
            username=scanner.nextLine();
            login(this);
            Logger.getInstance().log(
                    "Registered with name: "+username,
                    Logger.Level.INFO
            );
        }

        public Message getMessage(Scanner scanner) {
            Logger.getInstance().log(
                    "Waiting for message: ",
                    Logger.Level.INFO
            );
            String line = scanner.nextLine();
            Logger.getInstance().log(
                    "Parsing message: "+line,
                    Logger.Level.INFO
            );

            String[] messageParts = line.split(":");
            return new Message(getUsername(), messageParts[0], messageParts[1]);
        }

        public void sendMessage(Message message) {
            Logger.getInstance().log(
                    "Sending message: "+message.toString(),
                    Logger.Level.INFO
            );
            printStream.println(message.getMessage());
            printStream.flush();
            Logger.getInstance().log(
                    "Message sent: ",
                    Logger.Level.INFO
            );
        }

        @Override
        public void run() {
            super.run();
//            Scanner inputScanner = new Scanner(System.in);
            while(socket.isConnected()) {
                try {
                    Message message = getMessage(scanner);
                    Server.this.sendMessage(message);
                }
                catch (Exception ex) {

                }
            }
        }
    }

    public Server(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        users = new TreeMap<>();
    }

    @Override
    public void run() {
        super.run();

        while (!serverSocket.isClosed()) {
            try {
                Socket socket = serverSocket.accept();
                Logger.getInstance().log(
                        "A client is connected with address: "+socket.getRemoteSocketAddress(),
                        Logger.Level.INFO
                );
                new ServerUser(socket).start();
            } catch (IOException | AlreadyExistsException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void login(ServerUser client) throws AlreadyExistsException {
        if(users.keySet().contains(client.getUsername())) {
            throw new AlreadyExistsException();
        }
        users.put(client.getUsername(), client);
    }

    void sendMessage(Message message) {
        ServerUser destination = users.get(message.getDestination());
        destination.sendMessage(message);
    }
}
