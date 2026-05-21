/**
 * @author ValentinaTikko
 */
package okkit.editor.gui.app;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import okkit.editor.data.DataHandler;
import okkit.editor.data.dto.Question;
import okkit.editor.gui.Constants;

/**
 * Das Hauptpanel der Anwendung. Besteht aus drei separaten Panels.
 */
public class RootPanel extends JPanel implements Constants, AppListener {

	InputPanel inputPanel;
	EditorPanel editorPanel = new EditorPanel(true);
	ButtonPanel buttonPanel = new ButtonPanel(false);
	DataHandler handler = new DataHandler();

	/**
	 * Konstruiert das Panel.
	 */
	public RootPanel() {
		super();
		setLayout(null);
		inputPanel = new InputPanel(true, handler.getQuizTitleList());
		addComponents();
		setListener();
	}

	/**
	 * Setzt sich selbst als Listener aller Subpanels
	 */
	private void setListener() {
		buttonPanel.setAppListener(this);
		inputPanel.setAppListener(this);
	}

	/**
	 * Dimensioniert und addet die einzelnen Panels.
	 */
	private void addComponents() {
		int width = (int) (APP_WIDTH * 0.94);
		int x = 10;
		int y = 10;

		int height = (int) (APP_HEIGHT * 0.24);
		inputPanel.setBounds(x, y, width, height);
		add(inputPanel);

		y = y + height + 10;
		height = (int) (APP_HEIGHT * 0.55);
		editorPanel.setBounds(x, y, width, height);
		add(editorPanel);

		y = y + height + 10;
		height = (int) (APP_HEIGHT * 0.2);
		buttonPanel.setBounds(x, y, width, height);
		add(buttonPanel);
	}

	@Override
	public String saveQuestion() {
		Question q = editorPanel.getCurrentQuestion();
		String error = handler.saveQuestion(q);
		if (error == null) {
			popup("Question saved");
			inputPanel.updateQuestionList(q.getQuiz().getQuestions(), true);
		}
		return error;
	}

	@Override
	public void showQuestion(Question q) {
		editorPanel.showQuestion(q);
	}

	@Override
	public String dublicateQuestion() {
		popup("dublicateQuestion");
		return null;
	}

	@Override
	public String deleteQuestion() {
		popup("deleteQuestion");
		return null;
	}

	@Override
	public void newQuestion() {
		editorPanel.clear();
		inputPanel.clear();
	}

	@Override
	public void quizWasSelected(String quiz) {
		List<Question> questions = handler.getQuizByTitle(quiz).getQuestions();
		if (questions != null)
			inputPanel.updateQuestionList(questions, false);
	}

	private void popup(String text) {
		JOptionPane.showMessageDialog(this, text);
	}
}
