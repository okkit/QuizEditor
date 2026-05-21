package okkit.editor.gui.app;

import okkit.editor.data.dto.Question;

public interface AppListener {
	
	public void quizWasSelected(String quiz);
	public void showQuestion(Question q);
	public void newQuestion();
	public String saveQuestion();
	public String dublicateQuestion();
	public String deleteQuestion();
}
