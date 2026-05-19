package okkit.editor.gui.appComponents;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import okkit.editor.gui.Constants;

public class AppSubPanel extends JPanel implements Constants{
	
	public AppSubPanel(boolean bordered) {
		super();
		setLayout(null);
		if (bordered)
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
	}
	
	public void addElement(Component comp, String labeltext) {
		AppLabel label = new AppLabel(labeltext);
		add(label);
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		super.add(comp);	
	}

}
