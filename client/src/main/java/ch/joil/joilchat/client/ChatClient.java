package ch.joil.joilchat.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by bananatreedad on 07/05/16.
 */
public class ChatClient implements Runnable {

    private Socket socket = null;
    private Thread thread = null;
    private Scanner scanner = null;
    private PrintWriter writer = null;
    private ChatClientThread clientThread = null;

    public ChatClient(String serverName, int serverPort) {
        System.out.println("Try to establish connection...");

        try {
            socket = new Socket(serverName, serverPort);
            System.out.println("Connected: " + socket);

            start();


        } catch (UnknownHostException e) {
            System.out.println("Unknown host: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Could not connect to server: " + e.getMessage());
        }

    }

    public void handle(String s) {
        if (s.equals("/bye")) {
            System.out.println("GOOD BYE. Press RETURN to exit...");
            stop();
        } else {
            System.out.println(s);
        }
    }

    @Override
    public void run() {
        while (thread != null) {
            // see https://docs.oracle.com/javase/7/docs/api/java/io/DataInputStream.html

            if (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                writer.println(s);
            }
            //TODO mal noch fixen
//                stop();

        }
    }

    private void start() throws IOException {
        scanner = new Scanner(System.in);
        writer = new PrintWriter(socket.getOutputStream(), true);

        if (thread == null) {
            clientThread = new ChatClientThread(this, socket);

            thread = new Thread(this);
            thread.start();
        }
    }

    private void stop() {
        if (thread != null) {
            thread = null;
        }
        try {
            if (scanner != null) scanner.close();
            if (writer != null) writer.close();
            if (socket != null) socket.close();

        } catch (IOException e) {
            System.out.println("Closing error...");
        }

        clientThread.close();
        clientThread.halt();
    }

}
