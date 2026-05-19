/**
 * @author okkit
 */
package okkit.editor.gui.app;

import javax.swing.JFrame;

import okkit.editor.gui.Constants;

/**
 * Starts the Application
 */
public class QuizEditorFrame extends JFrame implements Constants{
	
	public QuizEditorFrame() {
		super(APP_TITLE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(APP_SIZE);
		setLocation(900, 100);
		add(new RootPanel());
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new QuizEditorFrame();
	}

}
