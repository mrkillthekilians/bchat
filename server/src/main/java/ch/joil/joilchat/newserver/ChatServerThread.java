package ch.joil.joilchat.newserver;

import ch.joil.joilchat.server.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by bananatreedad on 23/05/16.
 */
public class ChatServerThread extends Thread {

    private ChatServer chatServer = null;
    private Socket clientSocket = null;

    private Scanner scanner = null;
    private PrintWriter printWriter = null;

    private boolean blinker = false;

    /**
     * @param clientSocket The accepted socket.
     * @param chatServer   The chatServer
     */
    public ChatServerThread(Socket clientSocket, ChatServer chatServer) {
        this.chatServer = chatServer;
        this.clientSocket = clientSocket;
    }

    public void open() {
        try {
            scanner = new Scanner(clientSocket.getInputStream());
            printWriter = new PrintWriter(clientSocket.getOutputStream(), true);

        } catch (IOException e) {
            System.out.println("Opening communication failed: " + e.getMessage());
        }

    }

    @Override
    public void run() {
        //TODO how do i close proper?
        blinker = true;
        while (blinker) {
            try {
                System.out.println(scanner.nextLine());
            } catch (NoSuchElementException e) {
                System.out.println("Halting connection");
                blinker = false;
               //TODO clientcount--
            }
        }
    }
}
