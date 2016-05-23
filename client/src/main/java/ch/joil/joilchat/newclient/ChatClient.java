package ch.joil.joilchat.newclient;

//ChatClient edited by Ilian Jäger, 23.05.16

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;

public class ChatClient {

	private Socket socket = null;

	public ChatClient(String host, int port) {

		try {
			socket = new Socket(host, port);
			System.out.println("Connected:" + socket);

		} catch (UnknownHostException e) {
			System.out.println("Unknown Host:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("Could not connect to Server:" + e.getMessage());
		}

		new ToServerThread(socket).start();
		//new FromServerThread(socket).start();

	}

}
