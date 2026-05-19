/**
 * @author ValentinaTikko
 */
package okkit.editor.gui.app;

import java.awt.event.ActionEvent;

import okkit.editor.data.DataHandler;
import okkit.editor.gui.appComponents.AppComboBox;
import okkit.editor.gui.appComponents.AppLabel;
import okkit.editor.gui.appComponents.AppSubPanel;

public class InputPanel extends AppSubPanel {
	

	AppComboBox comboA;
	AppComboBox comboB;

	/**
	 * Konstruiert das Panel
	 * 
	 * @param bordered
	 */
	public InputPanel(boolean bordered) {
		super(bordered);
		setLayout(null);

		comboA = new AppComboBox(DataHandler.getInstance().getQuizList());
		comboA.addActionListener(e -> quizSelected(e));
		comboB = new AppComboBox();

		addComponents();
	}

	private void quizSelected(ActionEvent e) {
		String title = (String) ((AppComboBox)e.getSource()).getSelectedItem();
		appListener.changeQuiz(title);
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
