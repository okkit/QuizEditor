/**
 * @author ValentinaTikko
 */
package okkit.editor.gui.app;

import javax.swing.JPanel;

import okkit.editor.gui.Constants;

/**
 * Das Hauptpanel der Anwendung. Besteht aus drei separaten Panels.
 */
public class RootPanel extends JPanel implements Constants{

	InputPanel inputPanel = new InputPanel(true);
	EditorPanel editorPanel = new EditorPanel(true);
	ButtonPanel buttonPanel = new ButtonPanel(false);

	/**
	 * Konstruiert das Panel.
	 */
	public RootPanel() {
		super();
		setLayout(null);
		addComponents();
	}

	/**
	 * Dimensioniert und addet die einzelnen Panels.
	 */
	private void addComponents() {
		int width = (int) (APP_WIDTH * 0.94);
		int x = 10;
		int y = 10;
		
		int height = (int) (APP_WIDTH * 0.2);
		inputPanel.setBounds(x, y, width, height);
		add(inputPanel);
		
		y = y + height + 10;
		height = (int) (APP_WIDTH * 0.52);
		editorPanel.setBounds(x, y, width, height);
		add(editorPanel);
		
		y = y + height + 10;
		height = (int) (APP_WIDTH * 0.2);
		buttonPanel.setBounds(x, y, width, height);
		add(buttonPanel);
	}

}
