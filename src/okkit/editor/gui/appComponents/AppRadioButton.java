package okkit.editor.gui.appComponents;

import javax.swing.JRadioButton;

public class AppRadioButton extends JRadioButton {
	
	private int number;

	public AppRadioButton(int number, int x, int y, int w, int h) {
		super("" + number);
		this.number = number;
		setBounds(x, y, w, h);
	}

	public int getNumber() {
		return number;
	}

}
