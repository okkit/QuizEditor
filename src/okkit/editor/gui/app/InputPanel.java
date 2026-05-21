/**
 * @author ValentinaTikko
 */
package okkit.editor.gui.app;

import java.awt.event.ItemEvent;
import java.util.List;

import okkit.editor.data.dto.Question;
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
	public InputPanel(boolean bordered, String[] quizList) {
		super(bordered);
		setLayout(null);

		quizListComboBox = new AppComboBox(quizList);
		quizListComboBox.addItemListener(e -> quizWasSelected(e));
		questionListComboBox = new AppComboBox();
		questionListComboBox.addItemListener(e -> questionWasSelected(e));

		addComponents();
	}

	/**
	 * Wird aufgerufen, wenn eine Frage in der Fragenliste ausgewählt wird
	 * 
	 * @param e
	 */
	private void questionWasSelected(ItemEvent e) {
		if (e.getStateChange() != ItemEvent.SELECTED)
			return;

		Question q = (Question) ((AppComboBox) e.getSource()).getSelectedItem();
		if (q == null)
			return;
		appListener.showQuestion(q);

	}

	/**
	 * Wird aufgerufen, wenn ein Quiz in der Quizliste ausgewählt wird
	 * 
	 * @param e
	 */
	private void quizWasSelected(ItemEvent e) {
		if (e.getStateChange() != ItemEvent.SELECTED)
			return;
		String title = (String) ((AppComboBox) e.getSource()).getSelectedItem();
		if (title == null)
			return;
		appListener.quizWasSelected(title);
	}

	/**
	 * Addet die zwei Comboboxen
	 */
	private void addComponents() {
		AppLabel label = new AppLabel("Quizthema", 10, 10, 100, 20);
		add(label);
		quizListComboBox.setBounds(10, 35, 480, 26);
		quizListComboBox.setSelectedIndex(-1);
		add(quizListComboBox);

		label = new AppLabel("Bereits vorhandenen Fragen", 10, 70, 300, 20);
		add(label);
		questionListComboBox.setBounds(10, 95, 480, 26);
		questionListComboBox.setSelectedIndex(-1);
		add(questionListComboBox);
	}

	/**
	 * Aktualisiert die Liste der Fragen.<br>
	 * Wird aufgerufen nach der Selektion eines Quizzes oder nach dem Speichern
	 * einer Frage.
	 * 
	 * @param questions
	 * @param afterSave
	 */
	public void updateQuestionList(List<Question> questions, boolean afterSave) {
		questionListComboBox.removeAllItems();
		if (questions == null) {
			questionListComboBox.setSelectedIndex(-1);
		} else {
			for (Question question : questions) {
				questionListComboBox.addItem(question);
			}
			questionListComboBox.setSelectedIndex(afterSave ? questions.size() - 1 : 0);
		}
	}

	public void changeQuestionSelection(boolean clear) {
		questionListComboBox.setSelectedIndex(clear ? -1 : questionListComboBox.getItemCount() - 1);
	}

	public void clear() {
		questionListComboBox.setSelectedIndex(-1);

	}

}
