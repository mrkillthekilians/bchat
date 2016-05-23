package ch.joil.joilchat.newclient;

/**
 * Created by bananatreedad on 07/05/16.
 */
public class JoilChatClient {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java JoilChatClient <localhost> <port>");
        } else {
//            new ChatClient("192.168.192.31", 7777);
            new ChatClient(args[0], Integer.parseInt(args[1]));
        }
    }
}

