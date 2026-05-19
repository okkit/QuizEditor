package okkit.editor.gui.appComponents;

import javax.swing.JComboBox;

import okkit.editor.gui.Constants;

public class AppComboBox extends JComboBox<Object> implements Constants{
	
	public AppComboBox() {
		super();
		setFont(TEXT_FONT);	
	}
	
	public AppComboBox(String[] data) {
		super(data);
		setFont(TEXT_FONT);	
	}

}
