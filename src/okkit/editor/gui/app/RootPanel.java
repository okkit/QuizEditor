/**
 * @author ValentinaTikko
 */
package okkit.editor.gui.app;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import okkit.editor.data.DataHandler;
import okkit.editor.data.dto.Question;
import okkit.editor.gui.Constants;

/**
 * Das Hauptpanel der Anwendung. Besteht aus drei separaten Panels.
 */
public class RootPanel extends JPanel implements Constants, AppListener {

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

		int height = (int) (APP_HEIGHT * 0.2);
		inputPanel.setBounds(x, y, width, height);
		add(inputPanel);

		y = y + height + 10;
		height = (int) (APP_HEIGHT * 0.56);
		editorPanel.setBounds(x, y, width, height);
		add(editorPanel);

		y = y + height + 10;
		height = (int) (APP_HEIGHT * 0.2);
		buttonPanel.setBounds(x, y, width, height);
		add(buttonPanel);
	}

	@Override
	public String saveQuestion() {
		Question quest = DataHandler.getInstance().getCurrentQuestion();
		editorPanel.pack(quest);
		System.out.println(quest.toString());
		String error = DataHandler.getInstance().saveQuestion();
		popup(error == null ? "Question saved" : error);
		return null;
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
	public String newQuestion() {
		popup("newQuestion");
		return null;
	}

	@Override
	public void changeQuiz(String quiz) {
		popup(quiz);
	}

	private void popup(String text) {
		JOptionPane.showMessageDialog(this, text);
	}
}
