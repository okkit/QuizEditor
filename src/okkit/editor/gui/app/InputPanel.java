/**
 * @author ValentinaTikko
 */
package okkit.editor.gui.app;

import okkit.editor.gui.appComponents.AppComboBox;
import okkit.editor.gui.appComponents.AppLabel;
import okkit.editor.gui.appComponents.AppSubPanel;

public class InputPanel extends AppSubPanel {
	
	AppComboBox comboA = new AppComboBox();
	AppComboBox comboB = new AppComboBox();
	
	/**
	 * Konstruiert das Panel
	 * @param bordered
	 */
	public InputPanel(boolean bordered) {
		super(bordered);
		setLayout(null);
		addComponents();
	}

	/**
	 * Addet die zwei Comboboxen
	 */
	private void addComponents() {
		AppLabel label = new AppLabel("Quizthema");
		label.setBounds(10, 10, 100, 20);
		add(label);
		comboA.setBounds(10, 30, 480, 26);
		add(comboA);
		
		label = new AppLabel("Bereits vorhandenen Fragen");
		label.setBounds(10, 60, 300, 20);
		add(label);
		comboB.setBounds(10, 80, 480, 26);
		comboB.setSelectedIndex(-1);
		add(comboB);
	}

}
