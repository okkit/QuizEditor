package okkit.editor.gui.examples;

import javax.swing.JFrame;

import okkit.editor.gui.examples.cards.CardPanel;

public class Start extends JFrame {
	
	public Start() {
		super("Test");
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		add(new CardPanel());
		setVisible(true);
	}

	public static void main(String[] args) {

		new Start();

	}

}
