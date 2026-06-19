/**
 * @author ValentinaTikko
 */
package okkit.editor.data;

import okkit.editor.data.dto.Quiz;

/**
 * Die Klasse serialisiert die Instanzen der Klasse quiz.<br>
 * Die Klasse ist ein Singleton, d.h. es kann nur eine einzige<br>
 * instanz der Klasse geben.
 */
public class AppJSONhandler extends QuizSaver {

	private static final String FOLDER = "JSONData";
	private static final String EXTENTION = ".json";

	/**
	 * Die einzig mögliche Instanz dieser Klasse.
	 */
	private static final AppJSONhandler instance = new AppJSONhandler();

	public static AppJSONhandler getInstance() {
		return instance;
	}

	/**
	 * Da die Klasse ein Singleton ist, muss verhindert werden, dass<br>
	 * weitere Instanzen der Klasse erzeugt werden. Deswegen ist der Konstruktor
	 * private!
	 */
	private AppJSONhandler() {
		super(FOLDER, EXTENTION);
	}

	@Override
	public Quiz loadQuiz(String title) {
//
//		File file = new File(getFileName(title));
//		if (!file.exists())
//			return null;
//
//		ObjectMapper mapper = new ObjectMapper();
//
//		try {
//			Quiz quiz = mapper.readValue(file, Quiz.class);
//			return quiz;
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

		return null;
	}

	@Override
	public String saveQuiz(Quiz quiz) {

//		JSONObject quizJSON = new JSONObject(quiz);
//
//		String fileName = getFileName(quiz.getTitle());
//		try (FileWriter file = new FileWriter(fileName)) {
//			file.write(quizJSON.toString());
//			file.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		return null;
	}
}
