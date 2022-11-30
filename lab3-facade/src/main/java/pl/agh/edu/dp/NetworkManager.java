package pl.agh.edu.dp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.stream.IntStream;

public class NetworkManager {
    public final String LOCALHOST = "127.0.0.1";
    private final int MIN_PORT = 6066;
    private final int MAX_PORT = 6123;

    private ServerSocket serverSocket;
    private final Map<String, Integer> otherClientsPortByName = new HashMap<>();
    private int port = -1;
    private final String name;

    public NetworkManager(String name) {
        this.name = name;
        createServerSocketWithFreePort();
    }

    public void sendJoinBroadcast(){
        sendBroadcast("name:" + name + " port:" + port, Commands.JOIN);
    }


    public void sendDisconnect(){
        sendBroadcast("name:" + name, Commands.DISCONNECT);
    }

    public void close(){
        try {
            serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void createServerSocketWithFreePort() {
        IntStream.rangeClosed(MIN_PORT, MAX_PORT).takeWhile(n -> port == -1).forEach(p -> {
            try {
                serverSocket = new ServerSocket(p);
                port = p;
            } catch (IOException ignored) {
            }
        });

        if (port == -1)
            throw new RuntimeException("Could not find free port");
    }

    public void sendBroadcast(String message){
        IntStream.rangeClosed(MIN_PORT, MAX_PORT)
                .parallel()
                .filter(n -> n != port)
                .forEach(p -> sendMessage(message, p));
    }

    public void sendBroadcast(String message, Commands command){
        IntStream.rangeClosed(MIN_PORT, MAX_PORT)
                .parallel()
                .filter(n -> n != port)
                .forEach(p -> sendMessage(message, p, command));
    }

    public void sendMessage(String message, String username){
        try {
            Socket socket = new Socket(LOCALHOST, otherClientsPortByName.get(username));
            send(message, socket);
        } catch (IOException ignored) {

        }
    }

    public void sendMessage(String message, String username, Commands command){
        try {
            Socket socket = new Socket(LOCALHOST, otherClientsPortByName.get(username));
            send(message, socket, command);
        } catch (IOException ignored) {

        }
    }

    public void sendMessage(String message, int userPort){
        try {
            Socket socket = new Socket(LOCALHOST, userPort);
            send(message, socket);
        } catch (IOException ignored) {

        }
    }

    public void sendMessage(String message, int userPort, Commands command){
        try {
            Socket socket = new Socket(LOCALHOST, userPort);
            send(message, socket, command);
        } catch (IOException ignored) {

        }
    }

    public void sendStopReceiving(){
        try {
            Socket socket = new Socket(LOCALHOST, port);
            send("", socket, Commands.STOP_RECEIVING);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private void send(String message, Socket socket) throws IOException {
        send(name + ": " + message, socket, Commands.MESSAGE);
    }

    private void send(String message, Socket socket, Commands command) throws IOException {
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        printWriter.println(command.name() + "> " + message);
        printWriter.close();
        socket.close();
    }

    public List<String> getActiveUsers(){
        return new ArrayList<>(otherClientsPortByName.keySet());
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public Map<String, Integer> getOtherClientsPortByName() {
        return otherClientsPortByName;
    }

    public int getPort() {
        return port;
    }

    public String getName() {
        return name;
    }
}
