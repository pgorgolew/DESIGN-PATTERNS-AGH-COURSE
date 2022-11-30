package pl.agh.edu.dp;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        ChatFacadeImpl chat = new ChatFacadeImpl(args[0]);
        chat.start();

        int i = 0;
        while (!chat.isChatClosed()){
            chat.sendBroadcastMessage("Hey this is broadcast");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            List<String> users = chat.getActiveUsers();
            System.out.println(Arrays.toString(chat.getCommands()));
            System.out.println(users);

            users.forEach(user -> {
                chat.sendMessage("Private message for " + user, user);
            });

            i++;
            if (i > 3){
                chat.close();
            }
        }
    }
}

