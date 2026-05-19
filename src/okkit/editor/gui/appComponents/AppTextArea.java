package okkit.editor.gui.appComponents;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;

import okkit.editor.gui.Constants;

public class AppTextArea extends JTextArea implements Constants{
	
	public AppTextArea() {
		super();
		setFont(TEXT_FONT);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, false));
	}

}
