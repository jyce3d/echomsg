package be.sdlg.echo.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JScrollPane;

import javax.swing.JTextArea;

public class MessageView extends JScrollPane{
	public JTextArea txMessage;
	public MessageView() {
		this.txMessage = new JTextArea("");
		this.txMessage.setName("txMessage");
		this.txMessage.setEditable(false);
    	this.setViewportView(this.txMessage);
	}
}
