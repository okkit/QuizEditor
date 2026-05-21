package okkit.editor.data.dto;

import java.util.ArrayList;
import java.util.List;

public class Question extends DataTransportObject {

	private String text;
	private int score;
	/**
	 * Aggregation (Sammlung) der Instanzen der Klasse Answer, <br>
	 * bzw der Answer-Objekte.
	 */
	private List<Answer> answers = new ArrayList<Answer>();
	private Quiz quiz;

	// Standardkonstruktor
	public Question() {
		super();
		answers = new ArrayList<Answer>();
	}

	// Konstruktor
	public Question(String text) {
		this();
		this.text = text;
	}

	public void addAnswer(String text, boolean correct) {
		addAnswer(new Answer(text, correct));
	}

	public void addAnswer(Answer answer) {
		if (answers == null)
			answers = new ArrayList<Answer>();
		answers.add(answer);
		answer.setQuestion(this);
	}
	
	public String toString() {
		return text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	
	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Quiz getQuiz() {
		return quiz;
	}
}
