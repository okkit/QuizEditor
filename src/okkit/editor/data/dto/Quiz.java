package okkit.editor.data.dto;

import java.util.ArrayList;
import java.util.List;

public class Quiz extends DataTransportObject{

	private String title;
	private List<Question> questions;

	public Quiz(String title) {
		super();
		this.title = title;
	}
	
	public void addQuestion(String text) {		
		addQuestion(new Question(text));
	}
	
	public void addQuestion(Question question) {		
		if (questions == null)
			questions = new ArrayList<Question>();
		questions.add(question);
		question.setQuiz(this);
	}
	
	public boolean hasQuestion(Question quest) {
		System.out.println(quest);
		if (questions == null)
			return false;
		for (Question question : questions) {
			System.out.println(question);
		}
		return questions.contains(quest);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

}
