package ch.joil.joilchat.newclient;

//ToServerThread edited by Ilian Jäger, 23.05.16

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ToServerThread extends Thread {

	Socket socket = null;
	Scanner from_console = null;
	PrintWriter message_out = null;
	
	public ToServerThread(Socket socket) {
		super();
		this.socket = socket;
	}


	@Override
	public void run() {
		try{
			while(true){
				from_console = new Scanner(System.in);
				String string_message = from_console.nextLine();
				message_out = new PrintWriter(socket.getOutputStream(),true);
				message_out.println(string_message);
			}
		}
		catch(IOException e){
			System.out.println("Could not write to Server:" + e.getMessage());
		}
		
	}

	
}
