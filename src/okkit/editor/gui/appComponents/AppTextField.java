package okkit.editor.gui.appComponents;

import javax.swing.JTextField;

import okkit.editor.gui.Constants;

public class AppTextField extends JTextField implements Constants {

	public AppTextField(int x, int y, int w, int h) {
		super();
		setFont(TEXT_FONT);
		setBounds(x, y, w, h);
	}

}
