package be.sdlg.Socket;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import be.sdlg.echo.controller.ConnectDialog;
import be.sdlg.echo.view.EntryView;
import be.sdlg.echo.view.MessageView;


public class EchoClient extends JFrame {
	public static String host="";
	public static String port="";
	protected Socket echoSocket = null;
	protected PrintWriter out = null;
	protected BufferedReader in = null;
	protected JPanel mainPanel = null;
	protected MessageView messageView = null;
	protected EntryView entryView = null;
	public EchoClient() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Echo Client version 0.1");

	}
	public  void initDialog() {
     	ConnectDialog dlg = new ConnectDialog(this);
       	dlg.setVisible(true);

	}
	public void initMain() {
		// cree un socket lecture écrture sur le server.
		try {

			echoSocket = new Socket(host, Integer.valueOf(port));
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(echoSocket
					.getInputStream()));
			// create the views
			JPanel mainPanel = new JPanel();
			mainPanel.setLayout(new BorderLayout());
			messageView = new MessageView();
			mainPanel.add( messageView, BorderLayout.CENTER);

			entryView = new EntryView(out);
			mainPanel.add( entryView, BorderLayout.SOUTH);
			mainPanel.setPreferredSize(new Dimension(320,200));

			this.getContentPane().add(mainPanel);
			this.pack();

			EchoReader echoReader = new EchoReader("client",in, out, messageView);
			Thread readerThread = new Thread(echoReader);
			readerThread.start();

		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (IOException e) {
			e.printStackTrace();
		}

//		BufferedReader stdIn = new BufferedReader(new InputStreamReader(
//				System.in));
//		while (true) {
//			String userInput;
//			userInput  = stdIn.readLine();
//			if (userInput.equals("\\quit")) break;
//				out.println(userInput);
//
//		}
//		stdIn.close();


	}
	public static void main(String[] args) throws IOException {
		EchoClient echoClient = new EchoClient();
		echoClient.initDialog();
		echoClient.setVisible(true);
		}
	   public void dlgClose() {
	    	Container frame = this;
			while (!(frame instanceof JFrame))
					frame=frame.getParent();
			((JFrame) frame).dispose();

	    }
	  public void appClose() {
		  try {
				 in.close();
				out.close();
		  }catch (Exception e) {}
		  finally {
			  dlgClose();
		  }
	  }


}
