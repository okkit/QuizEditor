package okkit.editor.data;

import okkit.editor.data.dto.Question;
import okkit.editor.data.dto.Quiz;

public class DataHandler {

	public Quiz currentQuiz;

	public String[] getQuizTitleList() {
		return QuizList.list;
	}

	public Quiz getQuizByTitle(String title) {

		if (currentQuiz != null) {
			if (title.equals(currentQuiz.getTitle()))
				return currentQuiz;
		}
		currentQuiz = Serializer.getInstance().loadQuiz(title);
		if (currentQuiz == null)
			currentQuiz = new Quiz(title);
		return currentQuiz;
	}

	public Question dublicateQuestion(Question q) {
		// TODO 
		return null;
	}

	public String deleteQuestion(Question q) {
		if (q.getQuiz().getQuestions().remove(q))
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
		return Serializer.getInstance().saveQuiz(currentQuiz);
	}
}
