/**
 * @author ValentinaTikko
 */
package okkit.editor.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import okkit.editor.data.dto.Quiz;

/**
 * Die Klasse serialisiert die Instanzen der Klasse quiz.<br>
 * Die Klasse ist ein Singleton, d.h. es kann nur eine einzige<br>
 * instanz der Klasse geben.
 */
public class Serializer extends QuizSaver {

	private static final String FOLDER = "QuizData";
	private static final String EXTENTION = ".quiz";
	/**
	 * Die einzig mögliche Instanz dieser Klasse.
	 */
	private static final Serializer instance = new Serializer();

	public static Serializer getInstance() {
		return instance;
	}

	/**
	 * Da die Klasse ein Singleton ist, muss verhindert werden, dass<br>
	 * weitere Instanzen der Klasse erzeugt werden. Deswegen ist der Konstruktor
	 * private!
	 */
	private Serializer() {
		super(FOLDER, EXTENTION);
	}

	@Override
	public Quiz loadQuiz(String title) {

		File fileName = new File(getFileName(title));
		if (!fileName.exists())
			return null;
		try (FileInputStream fileInputStream = new FileInputStream(fileName);
				ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
			Quiz quiz = (Quiz) objectInputStream.readObject();
			return quiz;
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String saveQuiz(Quiz quiz) {

		File fileName = new File(getFileName(quiz.getTitle()));
		try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
			objectOutputStream.writeObject(quiz);
			objectOutputStream.flush();
		} catch (IOException e) {
			return e.getMessage();
		}
		return null;
	}

}
