package okkit.editor.gui.app;

import okkit.editor.data.dto.Question;

public interface AppListener {
	
	public void quizWasSelected(String quiz);
	public void showQuestion(Question q);
	public void newQuestion();
	public void saveQuestion();
	public void dublicateQuestion();
	public void deleteQuestion();
}
