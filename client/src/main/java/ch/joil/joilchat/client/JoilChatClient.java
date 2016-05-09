package ch.joil.joilchat.client;

/**
 * Created by bananatreedad on 07/05/16.
 */
public class JoilChatClient {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java JoilChatClient <port>");
        } else {
//            new ChatClient("192.168.192.31", 7777);
            new ChatClient("localhost", 7777);
        }
    }
}

