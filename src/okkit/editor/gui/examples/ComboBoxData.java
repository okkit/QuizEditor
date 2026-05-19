package okkit.editor.gui.examples;

public class ComboBoxData {
	
	int nummer;
	String eintrag;

	public ComboBoxData(int nummer, String eintrag) {
		super();
		this.eintrag = eintrag;
		this.nummer = nummer;
	}
	
	// Für die Anzeige der Texte in seiner Liste,
	// verwendet eine JCombobox die Methode toString()  
	// der Objekte.
	public String toString() {
		return eintrag + " " + nummer;
	}

}
