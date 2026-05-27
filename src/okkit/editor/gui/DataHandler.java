/**
 * @author ValentinaTikko
 */
package okkit.editor.gui;

import okkit.editor.data.AppJSONhandler;
import okkit.editor.data.QuizList;
import okkit.editor.data.QuizSaver;
import okkit.editor.data.dto.Question;
import okkit.editor.data.dto.Quiz;

/**
 * Die Klasse ist eine Schnittstelle zwischen den Daten- und der
 * Gui-Swing-Schichten.<br>
 */
public class DataHandler {

	public Quiz currentQuiz;
	
	private QuizSaver getSaver() {
//		return Serializer.getInstance();
		return AppJSONhandler.getInstance();
	}

	public String[] getQuizTitleList() {
		return QuizList.QUIZ_TITELS;
	}

	public Quiz getQuizByTitle(String title) {

		if (currentQuiz != null) {
			if (title.equals(currentQuiz.getTitle()))
				return currentQuiz;
		}
		
		currentQuiz = getSaver().loadQuiz(title);

		if (currentQuiz == null)
			currentQuiz = new Quiz(title);
		return currentQuiz;
	}

	public Question dublicateQuestion(Question q) {
		// TODO
		return null;
	}

	public String deleteQuestion(Question q) {
		if (currentQuiz.getQuestions().remove(q))
			return saveQuiz();
		else
			return "Fehler beim Löschen";
	}

	public String saveQuestion(Question q) {
		if (currentQuiz == null)
			return "Zu welchem Quiz gehört die Frage?";
		if (!currentQuiz.hasQuestion(q))
			currentQuiz.addQuestion(q);
		return saveQuiz();
	}

	private String saveQuiz() {

		return getSaver().saveQuiz(currentQuiz);
	}
}
