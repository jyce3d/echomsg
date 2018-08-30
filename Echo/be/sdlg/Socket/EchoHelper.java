package be.sdlg.Socket;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EchoHelper {
	public static void createLabel( String caption,  GridBagLayout gridbag, GridBagConstraints c, JPanel target) {
		JLabel label = new JLabel(caption);
		target.add(label,c);
	}
	public static JTextField createText( String name, String caption,  boolean editable, GridBagLayout gridbag, GridBagConstraints c, JPanel target) {
		JTextField text = new JTextField(caption);
		text.setEditable(editable);
		text.setName(name);

		target.add(text,c);
		return text;

	}
	public static JPasswordField createPassword( String name, String caption,   GridBagLayout gridbag, GridBagConstraints c, JPanel target) {
		JPasswordField text = new JPasswordField(caption);
		text.setName(name);

		target.add(text,c);
		return text;

	}

	public static JComboBox createCombo( String name, String[] caption,  GridBagLayout gridbag, GridBagConstraints c, JPanel target) {
		JComboBox combo = new JComboBox(caption);
		combo.setName(name);
		target.add(combo,c);

		return combo;
	}
	public static JComboBox createCombo(String name, Object[] caption, String toolTipText, JPanel target) {
		JComboBox combo = new JComboBox(caption);
		combo.setName(name);
		target.add(combo);
		combo.setToolTipText(toolTipText);
		return combo;
	}
	public static JButton createButton(String name, String caption, String tooltipText,  JPanel target) {
		JButton button= new JButton(caption);
		button.setName(name);
		button.setToolTipText(tooltipText);
		target.add(button);
		return button;

	}
	public static JButton createButton(String name, String caption, String tooltipText,   GridBagConstraints c, JPanel target) {
		JButton button= new JButton(caption);
		button.setName(name);
		button.setToolTipText(tooltipText);
		target.add(button, c);
		return button;

	}

}
