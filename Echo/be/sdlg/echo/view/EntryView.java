package be.sdlg.echo.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.PrintWriter;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class EntryView extends JPanel implements  KeyListener {
		protected PrintWriter out=null;
		public JTextField txSend;
		public EntryView(PrintWriter out) {
			this.out = out;
			this.setLayout(new GridLayout(0,1));
			txSend = new JTextField("");
			txSend.setName("txSend");
			txSend.setEditable(true);
			txSend.addKeyListener( this );
			this.add(txSend);
		}
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}
		public void keyReleased(KeyEvent e) {
			int key = e.getKeyCode();
			if (e.getSource()==txSend) {
				if (key == KeyEvent.VK_ENTER) {
					out.println(txSend.getText());
					txSend.setText("");
				}
			}
		}
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

}
