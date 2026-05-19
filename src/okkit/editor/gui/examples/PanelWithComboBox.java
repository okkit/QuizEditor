package okkit.editor.gui.examples;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelWithComboBox extends JPanel {
	
	public PanelWithComboBox() {
		super();
		setLayout(new GridLayout(0, 1));
		
		// Eine sehr einfache Combobox
		String[] dataA = {"aaaaaaaa", "bbbbbbbb", "ccccccc"};
		JComboBox<Object> comboboxA = new JComboBox<Object>(dataA);
		
		// Damit nicht das erste Element, d.h. "aaaaaaaaa" nicht
		// direkt angezteigt wird, setzte das selectedIndex = -1.
		comboboxA.setSelectedIndex(-1); 
		add(comboboxA);
		
		// Eine Combobox mit Objekten
		ArrayList<ComboBoxData> array = new ArrayList<ComboBoxData>();
		array.add(new ComboBoxData(1, "cccccccc"));
		array.add(new ComboBoxData(12, "dddddddd"));
		array.add(new ComboBoxData(10, "eeeeeeee"));
		
		ComboBoxData[] dataB = (ComboBoxData[]) array.toArray();		
		JComboBox<ComboBoxData> comboboxB = new JComboBox<ComboBoxData>(dataB);
		add(comboboxB);
		
	}
	
	private void popup() {
		String input = JOptionPane.showInputDialog(this,
                "Input?", null);
		System.out.println(input);
	}

}
