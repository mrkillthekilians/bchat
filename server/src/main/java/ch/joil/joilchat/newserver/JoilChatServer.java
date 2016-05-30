package ch.joil.joilchat.newserver;

/**
 * Created by bananatreedad on 23/05/16.
 */
public class JoilChatServer {

    public static void main(String[] args) {
        if (args.length != 1) System.out.println("Usage: java ch.joil.joilchat.newserver.JoilChatServer <port>");
        else new ChatServer(Integer.parseInt(args[0]));
    }
}
