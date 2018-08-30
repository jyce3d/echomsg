package be.sdlg.echo.controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import be.sdlg.echo.view.ConnectView;
import be.sdlg.Socket.EchoClient;

public class ConnectDialog extends JDialog implements ActionListener {
	/**
	 *
	 */
	private static final long serialVersionUID = -5130100266814121946L;
	ConnectView panelConnect = null;
	EchoClient appParent=null;
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() instanceof JButton) {
			if (  ((JButton) e.getSource() ).getName().equals("btOk") ) {

		          appParent.host = panelConnect.txHost.getText();
		          appParent.port = panelConnect.txPort.getText();
		          panelConnect.setVisible(false);
		          this.getContentPane().remove(panelConnect);

		          appParent.initMain();

		          this.dispose();
			} else if (((JButton) e.getSource() ).getName().equals("btClose") ) {
				this.dispose();
				this.appParent.dlgClose();
				System.exit(0);


			}
		}

	}

	public ConnectDialog( EchoClient parent) {
		this.setModal(true);

		this.appParent = parent;

		panelConnect = new ConnectView(this);
		panelConnect.setPreferredSize(new Dimension(320,200));

		this.setContentPane(panelConnect);
		this.pack();
		this.setLocationRelativeTo(parent);



	}



}
