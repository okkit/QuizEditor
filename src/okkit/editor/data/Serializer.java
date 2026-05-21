package okkit.editor.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import okkit.editor.data.dto.Question;
import okkit.editor.data.dto.Quiz;

public class Serializer {

	private static final Serializer instance = new Serializer();

	public static Serializer getInstance() {
		return instance;
	}

	private Serializer() {
	}

	public Quiz loadQuiz(String title) {

		File file = new File(Constants.FILE.formatted(title));
		try (FileInputStream fileInputStream = new FileInputStream(file);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			Quiz quiz = (Quiz) objectInputStream.readObject();
			return quiz;
		} catch (ClassNotFoundException | IOException e) {
			return null;
		}
	}

	public String saveQuiz(Quiz quiz) {

		try (FileOutputStream fileOutputStream = new FileOutputStream(
				Constants.FILE.formatted(quiz.getTitle()));
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(quiz);
			objectOutputStream.flush();
		} catch (IOException e) {
			return e.getMessage();
		}
		return null;
	}

	public String saveQuestion(Question q) {

		return saveQuiz(q.getQuiz());
	}

}
