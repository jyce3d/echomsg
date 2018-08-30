//http://www.kieser.net/linux/java_server.html
// threading questions
//http://www.fromdev.com/2008/05/java-threading-questions.html
package be.sdlg.Socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static final int PORT_NUMBER = 4719;
	public static final int MAX_CONNECTION = 255;
	public static void main(String[] args) {
System.out.println("Echo server version 0.1 by jyce3d is up and listening");
		// écouter sur un port
		int i=0;
		StringBuffer roomMessages=new StringBuffer();
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT_NUMBER);

		} catch(IOException e) {
System.out.println("Could not listen on the port:" + PORT_NUMBER);
			System.exit(-1);
		}
		// attend une connection
		Socket clientSocket =null;
		try {
			while (i++<MAX_CONNECTION ) {
				clientSocket = serverSocket.accept(); // attends jusqu'à ce que quelqu'un se connecte
				CommManager comManager =new CommManager(clientSocket);
				Thread t=new Thread(comManager);
				comManager.input = roomMessages;
				comManager.clientName = String.valueOf(t.getId());
System.out.println("Thread start "+ t.getId());
				t.start();

			}
		} catch(IOException e) {
System.out.println("Acceptance failed");
			System.exit(-1);
		}

	}

}
