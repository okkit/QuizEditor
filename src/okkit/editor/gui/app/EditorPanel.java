/**
 * @author ValentinaTikko
 */
package okkit.editor.gui.app;

import java.util.ArrayList;

import javax.swing.ButtonGroup;

import okkit.editor.data.dto.Question;
import okkit.editor.gui.appComponents.AppCheckBox;
import okkit.editor.gui.appComponents.AppLabel;
import okkit.editor.gui.appComponents.AppRadioButton;
import okkit.editor.gui.appComponents.AppSubPanel;
import okkit.editor.gui.appComponents.AppTextArea;
import okkit.editor.gui.appComponents.AppTextField;

/**
 * Das Panel mit der Eingabemaske für Frage und Antworten
 */
public class EditorPanel extends AppSubPanel {

	AppTextArea questionArea;
	ArrayList<AppTextField> anserTextFields = new ArrayList<AppTextField>(ANSER_NUMBER);
	ArrayList<AppCheckBox> anserCheckBoxes = new ArrayList<AppCheckBox>(ANSER_NUMBER);
	ArrayList<AppRadioButton> scoreRadioButtons = new ArrayList<AppRadioButton>(SCORE_NUMBER);
	ButtonGroup scoreGroup = new ButtonGroup();

	/**
	 * Konstruiert das Panel
	 * 
	 * @param bordered
	 */
	public EditorPanel(boolean bordered) {
		super(bordered);
		setLayout(null);
		addComponents();
	}

	/**
	 * Addet die einzelne Elemente
	 */
	private void addComponents() {
		
		add(new AppLabel("Fragentext", 10, 10, 100, 20));
		questionArea = new AppTextArea(10, 40, 480, 100);
		add(questionArea);

		add(new AppLabel("Score", APP_WIDTH - 100, 10, 60, 30));
		addScoreRadioButtons(APP_WIDTH - 100, 40);

		add(new AppLabel("Antworten", 10, 150, 100, 20));
		add(new AppLabel("Richtig", APP_WIDTH - 100, 150, 60, 30));

		addAnswerComponents(10, 180);
	}

	/**
	 * Addet die einzelnen Komponenten beginnend bei der Position x, y 
	 * @param x Position für Bounds
	 * @param y Position für Bounds
	 */
	private void addAnswerComponents(int x, int y) {
		AppTextField field;
		AppCheckBox box;
		for (int i = 0; i < ANSER_NUMBER; i++) {
			field = new AppTextField(x, y, 480, 26);
			box = new AppCheckBox(APP_WIDTH - 100, y, 20, 30);
			add(field);
			add(box);
			anserTextFields.add(field);
			anserCheckBoxes.add(box);
			y += 30;
		}

	}

	/**
	 * Addet Score-RadioButtons beginnend bei der Position x, y
	 * @param x
	 * @param y
	 */
	private void addScoreRadioButtons(int x, int y) {
		AppRadioButton rb;
		for (int i = 0; i < SCORE_NUMBER; i++) {
			rb = new AppRadioButton(i + 1, x, y, 50, 30);
			add(rb);
			y += 23;
			scoreGroup.add(rb);
			scoreRadioButtons.add(rb);
		}

	}

	/**
	 * Verpackt den Input in das Question-Objekt
	 * 
	 * @param quest
	 */
	public void pack(Question quest) {

		quest.setText(questionArea.getText());

		for (int i = 0; i < SCORE_NUMBER; i++) {
			if (scoreRadioButtons.get(i).isSelected())
				quest.setScore(scoreRadioButtons.get(i).getNumber());
		}

		for (int i = 0; i < ANSER_NUMBER; i++) {
			quest.addAnswer(anserTextFields.get(i).getText(), anserCheckBoxes.get(i).isSelected());
		}

	}

}
