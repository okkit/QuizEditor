package okkit.editor.gui.appComponents;

import java.awt.Dimension;

import javax.swing.JLabel;

import okkit.editor.gui.Constants;

public class AppLabel extends JLabel implements Constants{

	public AppLabel(String text, int x, int y, int w, int h) {
		super(text);
		setBounds(x, y, w, h);
		setFont(LABEL_FONT);
		setPreferredSize(new Dimension(60, 20));
	}

}
