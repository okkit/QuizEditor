/**
 * @author ValentinaTikko
 */
package okkit.editor.gui.app;

import okkit.editor.gui.appComponents.AppButton;
import okkit.editor.gui.appComponents.AppSubPanel;

/**
 * Das Panel mit allen Buttons
 */
public class ButtonPanel extends AppSubPanel {

	AppButton deleteButton = new AppButton(BUTTON_DELETE);
	AppButton dublicateButton = new AppButton(BUTTON_DUBLICATE);
	AppButton newButton = new AppButton(BUTTON_NEW);
	AppButton saveButton = new AppButton(BUTTON_SAVE);

	/**
	 * Konstruiert das Panel
	 * @param bordered
	 */
	public ButtonPanel(boolean bordered) {
		super(bordered);

		addComponents();
	}

	/**
	 * Addet die einzelnen Button
	 */
	private void addComponents() {
		
		add(deleteButton);
		add(dublicateButton);
		add(newButton);
		add(saveButton);
		
		setComponentBounds();
	}

	/**
	 * Bestimmt die Größe und die Position der einzelnen Komponenten
	 */
	private void setComponentBounds() {
		
		int x = 10;
		int y = 10;
		int w = APP_WIDTH / 5;
		int h = 30;
		int d = 12;
		deleteButton.setBounds(x, y, w, h);
		x = x + w + d;
		dublicateButton.setBounds(x, y, w, h);
		x = x + w + d;
		newButton.setBounds(x, y, w, h);
		x = x + w + 50;
		saveButton.setBounds(x, y, w, h);
	}

}
