package ch.joil.joilchat.client;

/**
 * Created by bananatreedad on 07/05/16.
 */
public class JoilChatClient2 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java JoilChatClient <port>");
        } else {
//            new ChatClient2("192.168.192.31", 7777);
            new ChatClient2("localhost", 7777);
        }
    }
}

