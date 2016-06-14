package ch.joil.joilchat.newclient;

//ToServerThread edited by Ilian Jäger, 23.05.16

import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ToServerThread extends Thread {

	Socket socket = null;
	Scanner from_console = null;
	PrintWriter message_out = null;
	JSONObject packet = new JSONObject();
	String username = null;
	String message = null;
	String to = "all";
	
	public ToServerThread(Socket socket) {
		super();
		this.socket = socket;
		
		from_console=new Scanner(System.in);
	}


	@Override
	public void run() {
		
		//set username
		System.out.println("Enter Username: ");
		username = from_console.nextLine();
		username = username.replaceAll(" ", "_");
		
		try{
			while(true){
				
				//fill JSON object "packet"
				packet.put("username",username);
				System.out.print(">");
				message=from_console.nextLine();
				
				//receiver address changed?
				while(message.startsWith("\\to")){
					message = message.replaceAll(" ", "_");
					to=message.substring(4);
					System.out.print(">");
					message = from_console.nextLine();
				}
				packet.put("to", to);
				packet.put("message", message);
				
				
				
				//send "packet" through outputstream
				//OutputStreamWriter out = new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8);
				//out.write(packet.toString());
				
				// without JSON:
				//from_console = new Scanner(System.in);
				//String string_message = from_console.nextLine();
				message_out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),StandardCharsets.UTF_8),true);
				message_out.println(packet.toString());
			}
		}
		catch(IOException e){
			System.out.println("Could not write to Server:" + e.getMessage());
		}
		
	}

	
}
