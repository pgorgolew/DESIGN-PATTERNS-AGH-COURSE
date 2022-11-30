package pl.agh.edu.dp;

import java.util.List;

public class ChatFacadeImpl implements ChatFacade {
    private NetworkManager networkManager;
    private MessageReceiver receiver;
    private boolean finished = true;
    private final String name;

    public ChatFacadeImpl(String name) {
        this.name = name;
    }

    @Override
    public void start() {
        finished = false;
        networkManager = new NetworkManager(name);
        receiver = new MessageReceiver(networkManager);
        receiver.start();
        networkManager.sendJoinBroadcast();
    }


    @Override
    public void sendBroadcastMessage(String message) {
        networkManager.sendBroadcast(message);
    }

    @Override
    public void sendMessage(String message, String username) {
        networkManager.sendMessage(message, username);
    }

    @Override
    public List<String> getActiveUsers() {
        return networkManager.getActiveUsers();
    }

    @Override
    public void restartChat() {
        close();
        start();
    }

    @Override
    public Commands[] getCommands() {
        return Commands.values();
    }

    @Override
    public boolean isChatClosed() {
        return finished;
    }

    @Override
    public void close() {
        networkManager.sendStopReceiving();
        receiver.stopReceiving();

        networkManager.sendDisconnect();
        networkManager.close();

        finished = true;
    }
}
