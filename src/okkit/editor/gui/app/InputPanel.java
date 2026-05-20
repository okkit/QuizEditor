/**
 * @author ValentinaTikko
 */
package okkit.editor.gui.app;

import java.awt.event.ActionEvent;

import okkit.editor.data.DataHandler;
import okkit.editor.gui.appComponents.AppComboBox;
import okkit.editor.gui.appComponents.AppLabel;
import okkit.editor.gui.appComponents.AppSubPanel;

/**
 * Das Panel mit zwei Comboboxen. <br>
 * Eine für die Liste der Quizzes. Eine für die Liste der Fragen.
 */
public class InputPanel extends AppSubPanel {

	AppComboBox quizListComboBox;
	AppComboBox questionListComboBox;

	/**
	 * Konstruiert das Panel
	 * 
	 * @param bordered
	 */
	public InputPanel(boolean bordered) {
		super(bordered);
		setLayout(null);

		quizListComboBox = new AppComboBox(DataHandler.getInstance().getQuizList());
		quizListComboBox.addActionListener(e -> quizSelected(e));
		questionListComboBox = new AppComboBox();

		addComponents();
	}

	/**
	 * Wird aufgerufen, wenn ein Quiz in der Liste ausgewählt wird
	 * 
	 * @param e
	 */
	private void quizSelected(ActionEvent e) {
		String title = (String) ((AppComboBox) e.getSource()).getSelectedItem();
		appListener.changeQuiz(title);
	}

	/**
	 * Addet die zwei Comboboxen
	 */
	private void addComponents() {
		AppLabel label = new AppLabel("Quizthema", 10, 10, 100, 20);
		add(label);
		quizListComboBox.setBounds(10, 35, 480, 26);
		add(quizListComboBox);

		label = new AppLabel("Bereits vorhandenen Fragen", 10, 70, 300, 20);
		add(label);
		questionListComboBox.setBounds(10, 95, 480, 26);
		questionListComboBox.setSelectedIndex(-1);
		add(questionListComboBox);
	}

}
