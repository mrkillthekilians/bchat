package ch.joil.joilchat.newserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by bananatreedad on 23/05/16.
 */
public class ChatServer {

    private int clientCount = 0;
    private ChatServerThread[] clients = new ChatServerThread[50];

    private ServerSocket serverSocket = null;

    /**
     * The ChatServer is the Mainclass of the server.
     * It listens on a port for connections and opens a new ChatServerThread for each connected client.
     *
     * @param port
     */
    public ChatServer(int port) {

        try {
            serverSocket = new ServerSocket(port);

            System.out.println("Binding port " + port + " on " + serverSocket.getLocalSocketAddress());
            System.out.println("Server started.");

            startListening();

        } catch (IOException e) {
            System.out.println("Error opening Socket: " + e.getMessage());
        }

    }

    private void startListening() throws IOException {
        while (clientCount < clients.length) {

            addThread(serverSocket.accept());
        }
    }

    private void addThread(Socket acceptedSocket) throws IOException {
        System.out.print("Connection accepted: " + acceptedSocket);

        clients[clientCount] = new ChatServerThread(acceptedSocket, this);

        clients[clientCount].open();
        clients[clientCount].start();

        clientCount++;

        System.out.println(" | Clientcount: " + clientCount);
    }
}
