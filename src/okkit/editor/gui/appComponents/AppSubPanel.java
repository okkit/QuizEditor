package okkit.editor.gui.appComponents;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import okkit.editor.gui.Constants;
import okkit.editor.gui.app.AppListener;

public class AppSubPanel extends JPanel implements Constants{
	
	protected AppListener appListener;
	
	public AppSubPanel(boolean bordered) {
		super();
		setLayout(null);
		if (bordered)
			setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
	}

	public void setAppListener(AppListener appListener) {
		this.appListener = appListener;
	}

}
