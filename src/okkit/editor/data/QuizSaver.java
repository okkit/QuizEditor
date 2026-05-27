/**
 * @author ValentinaTikko
 */
package okkit.editor.data;

import java.io.File;
import java.util.Objects;

import okkit.editor.data.dto.Quiz;

/**
 * Die Klasse definiert alle Klassen, die für das Speichern/Lesen von Quizzes
 * verantwortlich sind.<br>
 * Jeder der Childklassen diser Klasse muss via Konstruktorparameter<br>
 * die Felder folderName und extention initialisieren
 */
public abstract class QuizSaver {

	protected final String folderName;
	protected final String extention;

	public abstract Quiz loadQuiz(String title);

	public abstract String saveQuiz(Quiz quiz);

	public QuizSaver(String folderName, String extention) {

		super();
		this.folderName = Objects.requireNonNull(folderName);
		this.extention = Objects.requireNonNull(extention);
	}

	/**
	 * Stellt den kompletten Namen des Files zusammen.
	 * 
	 * @param title
	 * @return
	 */
	protected String getFileName(String title) {

		return getFolderName() + title + extention;
	}

	/**
	 * Liefert den kompletten Verzeichnisnamen.
	 * 
	 * @return
	 */
	
	private String getFolder() {

		return getPath() + "/" + folderName;
	}
	private String getFolderName() {

		String folderName = getFolder();
		File file = new File(folderName);
		if (!file.exists())
			file.mkdir();

		return folderName + "/";
	}

	/**
	 * Liefert den Namen des Rootverzeichnisses.
	 * 
	 * @return
	 */
	private String getPath() {

		return this.getClass().getClassLoader().getResource("").getPath();
	}
}
