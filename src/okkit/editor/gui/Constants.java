package okkit.editor.gui;

import java.awt.Font;
import java.awt.Rectangle;

public interface Constants {

	public static final int ANSER_NUMBER = 4;
	
	public static final String APP_TITLE = "Editor";
	
	public static final String BUTTON_DELETE = "Löschen";
	public static final String BUTTON_NEW = "Neue Frage";
	public static final String BUTTON_DUBLICATE = "Dublizieren";
	public static final String BUTTON_SAVE = "Speichern";
	
	public static final int APP_WIDTH = 600;
	public static final int APP_HEIGHT = 560;
	public static final Rectangle APP_SIZE = new Rectangle(APP_WIDTH, APP_HEIGHT);
	
	public static final Font LABEL_FONT = new Font("Trebushet", Font.PLAIN, 16);
	public static final Font TEXT_FONT = new Font("Trebushet", Font.PLAIN, 16);
	public static final Font BUTTON_FONT = new Font("Trebushet", Font.PLAIN, 16);
}
