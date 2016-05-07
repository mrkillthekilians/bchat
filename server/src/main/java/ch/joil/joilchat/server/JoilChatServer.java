package ch.joil.joilchat.server;

/**
 * Created by bananatreedad on 06/05/16.
 */
public class JoilChatServer {
    public static void main(String[] args) {
        if(args.length != 1) System.out.println("Usage: java ch.joil.joilchat.server.JoilChatServer <port>");
        else new ChatServer(Integer.parseInt(args[0]));
    }
}
