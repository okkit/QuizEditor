package okkit.editor.gui.appComponents;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import okkit.editor.gui.Constants;

public class AppTextArea extends JTextArea implements Constants{
	
	public AppTextArea(int x, int y, int w, int h) {
		super();
		setFont(TEXT_FONT);
		setBounds(x, y, w, h);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
	}

}
