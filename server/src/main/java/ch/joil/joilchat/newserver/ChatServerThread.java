package ch.joil.joilchat.newserver;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
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
            //getting {"message":"message","username":"username","to":"to_username or all"}
            scanner = new Scanner(clientSocket.getInputStream(), "utf-8");

            printWriter = new PrintWriter(clientSocket.getOutputStream(), true);

        } catch (IOException e) {
            System.out.println("Opening communication failed: " + e.getMessage());
        }
    }

    public void writeToClient(String string) {
       printWriter.write(string);
    }

    @Override
    public void run() {
        blinker = true;
        while (blinker) {
            try {

                JSONParser parser = new JSONParser();
                Object obj = parser.parse(scanner.nextLine());

                JSONObject jsonObject = (JSONObject) obj;
                System.out.println(jsonObject.toJSONString());

                System.out.println("username: " + jsonObject.get("username"));
                System.out.println("to: " + jsonObject.get("to"));
                System.out.println("message: "  + jsonObject.get("message"));

                chatServer.handle(jsonObject);

            } catch (NoSuchElementException e) {
                System.out.println("Halting connection: " + clientSocket.toString());
                blinker = false;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
