package okkit.editor.gui.appComponents;

import java.awt.Color;

import javax.swing.JButton;

import okkit.editor.gui.Constants;

public class AppButton extends JButton implements Constants{

	public AppButton(String text) {
		super(text);

		setFocusable(false);
		setOpaque(false);
		setBackground(Color.GRAY);
		setFont(BUTTON_FONT);

	}

}
