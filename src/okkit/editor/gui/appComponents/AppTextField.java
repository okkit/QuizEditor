package okkit.editor.gui.appComponents;

import java.awt.Dimension;

import javax.swing.JTextField;

import okkit.editor.gui.Constants;

public class AppTextField extends JTextField implements Constants {

	public AppTextField() {
		super();
		setFont(TEXT_FONT);
		setPreferredSize(new Dimension(30, 30));
	}

}
