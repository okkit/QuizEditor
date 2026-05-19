package okkit.editor.gui.appComponents;

import javax.swing.JRadioButton;

public class AppRadioButton extends JRadioButton {
	
	private int number;

	public AppRadioButton(int number) {
		super("" + number);
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

}
