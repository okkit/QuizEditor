package okkit.editor.data;

import okkit.editor.data.dto.Question;
import okkit.editor.data.dto.Quiz;

public class DataHandler {

	private static final DataHandler instance = new DataHandler();
	private Quiz currentQuiz;
	private Question currentQuestion;
	
	public String saveQuiz() {
		return null;
	}
	
	public String saveQuestion() {
		if (!currentQuiz.hasQuestion(currentQuestion))
			currentQuiz.addQuestion(currentQuestion);
		return null;
	}
	
	public String[] getQuizList() {
		return QuizList.list;
	}

	public Quiz loadQuiz(String title) {
		currentQuiz = new Quiz(title);
		return currentQuiz;
	}

	public Question createNewQuestion() {
		currentQuestion = new Question();
		return currentQuestion;
	}

	public Question getCurrentQuestion() {
		if (currentQuestion == null)
			return createNewQuestion();
		return currentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public Quiz getQuiz() {
		return currentQuiz;
	}

	public void setQuiz(Quiz quiz) {
		this.currentQuiz = quiz;
	}

	public static DataHandler getInstance() {
		return instance;
	}

	private DataHandler() {
		super();
	}

}
