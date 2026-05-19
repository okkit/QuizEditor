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

	AppTextArea questionArea = new AppTextArea();
	ArrayList<AppTextField> anserFields = new ArrayList<AppTextField>(ANSER_NUMBER);
	ArrayList<AppCheckBox> checkBoxes = new ArrayList<AppCheckBox>(ANSER_NUMBER);
	ArrayList<AppRadioButton> radios = new ArrayList<AppRadioButton>(SCORE_NUMBER);
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
		AppLabel label = new AppLabel("Fragentext");
		label.setBounds(10, 10, 100, 20);
		add(label);
		questionArea.setBounds(10, 40, 480, 100);
		add(questionArea);

		label = new AppLabel("Score");
		label.setBounds(APP_WIDTH - 100, 10, 60, 30);
		add(label);

		int y = 40;
		int x = APP_WIDTH - 100;
		AppRadioButton rb;
		for (int i = 0; i < SCORE_NUMBER; i++) {
			rb = new AppRadioButton(i + 1);
			rb.setBounds(x, y, 50, 30);
			add(rb);
			y += 23;
			scoreGroup.add(rb);
			radios.add(rb);
		}

		label = new AppLabel("Antworten");
		label.setBounds(10, 150, 100, 20);
		add(label);
		label = new AppLabel("Richtig");
		label.setBounds(APP_WIDTH - 100, 150, 60, 30);
		add(label);

		x = 10;
		y = 180;

		AppTextField field;
		AppCheckBox box;
		for (int i = 0; i < ANSER_NUMBER; i++) {
			field = new AppTextField();
			box = new AppCheckBox();
			field.setBounds(x, y, 480, 26);
			box.setBounds(APP_WIDTH - 100, y, 20, 30);
			add(field);
			add(box);
			anserFields.add(field);
			checkBoxes.add(box);
			y += 30;
		}
	}

	public void pack(Question quest) {

		quest.setText(questionArea.getText());

		for (int i = 0; i < SCORE_NUMBER; i++) {
			if (radios.get(i).isSelected())
				quest.setScore(radios.get(i).getNumber());
		}
		

		for (int i = 0; i < ANSER_NUMBER; i++) {
			quest.addAnswer(anserFields.get(i).getText(), checkBoxes.get(i).isSelected());
		}

	}

}
