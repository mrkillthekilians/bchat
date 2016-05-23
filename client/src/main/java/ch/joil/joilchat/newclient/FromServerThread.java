package ch.joil.joilchat.newclient;

//FromServerThread edited by Ilian Jäger, 23.05.16

import java.net.Socket;

public class FromServerThread extends Thread{
	
	Socket socket = null;
	
	public FromServerThread(Socket socket) {
		super();
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
	}

	
}
