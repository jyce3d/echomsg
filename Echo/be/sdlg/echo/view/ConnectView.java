package be.sdlg.echo.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import be.sdlg.echo.controller.ConnectDialog;
import be.sdlg.Socket.EchoHelper;





public class ConnectView extends JPanel  {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public JButton btOk, btClose;
    public JTextField txHost, txPort;


    public ConnectView(ConnectDialog parent) {
        GridBagLayout gridbag = new GridBagLayout();
        this.setLayout(gridbag);
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx=0.5;
        c.gridx=0;
        c.gridy=0;
        EchoHelper.createLabel("Host", gridbag, c , this);
        c.gridx=1;
        c.gridy=0;
        txHost = EchoHelper.createText("txHost", "127.0.0.1", true, gridbag, c, this);
        c.gridx=0;
        c.gridy=1;
        EchoHelper.createLabel("Port", gridbag, c , this);
        c.gridx=1;
        c.gridy=1;
        txPort = EchoHelper.createText("txPort", "4719", true, gridbag, c, this);

        c.gridx=0;
        c.gridy=3;
        btOk = EchoHelper.createButton("btOk","Connect","Connection", c, this);
        btOk.addActionListener(parent);
        c.gridx=1;
        c.gridy=3;
        btClose = EchoHelper.createButton("btClose","Close","Close App", c, this);
        btClose.addActionListener(parent);

        this.revalidate();

    }




}
