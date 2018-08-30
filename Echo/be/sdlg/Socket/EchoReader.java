package be.sdlg.Socket;

import java.io.BufferedReader;
import java.io.PrintWriter;

import be.sdlg.echo.view.MessageView;

public class EchoReader implements Runnable {
	private BufferedReader in;
	private PrintWriter out;
	private MessageView messageView;

	public EchoReader(String client, BufferedReader in, PrintWriter out, MessageView messageView) {
		this.in = in;
		this.out = out;
		this.messageView = messageView;
	}
	public void run() {
		try {
			while (true) {

			Thread.sleep(1000);
			out.println("\\ping");
//			Runtime.getRuntime().exec("clear");
				String inputLine;
				String text ="";
				while( !(inputLine = in.readLine()).equals("\\pong") ) {
					text+=inputLine+"\n";

				}
				messageView.txMessage.setText(text);
//				messageView.txMessage.repaint();
				messageView.txMessage.revalidate();

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}


}
