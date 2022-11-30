package pl.agh.edu.dp;

import java.util.List;
import java.util.Set;

public interface ChatFacade {
    void start();
    void sendBroadcastMessage(String message);
    void sendMessage(String message, String username);
    List<String> getActiveUsers();
    void restartChat();
    Commands[] getCommands();
    boolean isChatClosed();
    void close();


}
