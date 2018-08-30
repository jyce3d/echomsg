package be.sdlg.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class CommManager implements Runnable {
	private Socket clientSocket;
	public StringBuffer input ;
	private String line;
	public String clientName;

	public CommManager(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	public void run() {
		try {
				BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				PrintStream out = new PrintStream(clientSocket.getOutputStream());
				while ( (line = in.readLine()) !=null ) {
					if (line.equals("\\ping")) {
						out.println(input.toString());
						out.println("\\pong");
					} else {
						input.append(clientName+">"+line+"\n");
						System.out.println("got this :"+line);

					}
				}
				clientSocket.close();
		} catch(IOException ioe) {
			System.out.println("IOException on socket listen:" );
			ioe.printStackTrace();
		}

	}


}
