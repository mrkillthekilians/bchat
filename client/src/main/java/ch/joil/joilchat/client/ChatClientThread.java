package ch.joil.joilchat.client;

import java.io.IOException;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Created by bananatreedad on 07/05/16.
 */
public class ChatClientThread extends Thread {
    ChatClient chatClient = null;
    Socket socket = null;
    Scanner scanner = null;

    private volatile Thread blinker = null;

    public ChatClientThread(ChatClient chatClient, Socket socket) {
        this.chatClient = chatClient;
        this.socket = socket;
        open();

        blinker = new Thread(this);
        start();

    }

    @Override
    public void run() {
        while(blinker != null) {
            try {
                chatClient.handle(scanner.nextLine());
            } catch (NoSuchElementException ex) {
                System.out.println("Lost connection to server.");
                close();
                halt();
            }
        }
    }

    private void open() {
        try {
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Error opening input stream: " + e.getMessage());
            this.halt();
        }
    }

    public void close() {
        try {
            if (scanner != null) scanner.close();
            if (socket != null) socket.close();
        } catch (IOException e) {
            System.out.println("Closing error...");
        }
    }

    public void halt() {
        close();
        blinker = null;
    }
}
