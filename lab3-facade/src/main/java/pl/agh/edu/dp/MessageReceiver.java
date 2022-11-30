package pl.agh.edu.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageReceiver extends Thread{
    NetworkManager networkManager;
    private final Pattern commandPattern = Pattern.compile("(?<cmd>[a-zA-Z_]+)> (?<msg>.*)");
    private final Pattern joinPattern = Pattern.compile("name:(?<name>\\S+) port:(?<port>\\d+)");
    private final Pattern disconnectPattern = Pattern.compile("name:(?<name>\\S+)");
    private boolean finishReceiving = false;

    public MessageReceiver(NetworkManager networkManager) {
        this.networkManager = networkManager;

    }

    @Override
    public void run() {
        while(!finishReceiving){
            try {
                Socket receiverSocker = networkManager.getServerSocket().accept();
                BufferedReader input = new BufferedReader(new InputStreamReader(receiverSocker.getInputStream()));
                String line = input.readLine();
                Matcher commandMatcher = commandPattern.matcher(line);
                if (commandMatcher.matches()){
                    Commands command = Commands.valueOf(commandMatcher.group("cmd"));
                    String message = commandMatcher.group("msg");

                    switch (command) {
                        case JOIN -> handleJoin(message);
                        case JOIN_ANSWER -> handleJoinAnswer(message);
                        case DISCONNECT -> handleDisconnect(message);
                        case MESSAGE -> handleMessage(message);
                        case STOP_RECEIVING -> handleStopReceiving();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void handleJoinAnswer(String message){
        Matcher joinMatcher = joinPattern.matcher(message);
        if (joinMatcher.matches()){
            String name = joinMatcher.group("name");
            int port = Integer.parseInt(joinMatcher.group("port"));
            networkManager.getOtherClientsPortByName().put(name, port);
        }
    }

    private void handleJoin(String message){
        Matcher joinMatcher = joinPattern.matcher(message);
        if (joinMatcher.matches()){
            String name = joinMatcher.group("name");
            int port = Integer.parseInt(joinMatcher.group("port"));
            networkManager.getOtherClientsPortByName().put(name, port);
            sendJoinAnswer(port);
            System.out.println("User " + name + " joined the chat");
        }
    }

    private void handleDisconnect(String message){
        Matcher joinMatcher = disconnectPattern.matcher(message);
        if (joinMatcher.matches()) {
            String name = joinMatcher.group("name");
            networkManager.getOtherClientsPortByName().remove(name);
            System.out.println("User " + name + " has left the chat");
        }
    }

    private void handleStopReceiving(){
        finishReceiving = true;
    }

    private void handleMessage(String message){
        System.out.println(message);
    }

    private void sendJoinAnswer(int toPort){
        String message = "name:" + networkManager.getName() + " port:" + networkManager.getPort();
        networkManager.sendMessage(message, toPort, Commands.JOIN_ANSWER);
    }

    public void stopReceiving(){
        try {
            this.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
