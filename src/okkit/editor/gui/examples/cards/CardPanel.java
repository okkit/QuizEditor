package okkit.editor.gui.examples.cards;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class CardPanel extends JPanel implements MouseListener{

	CardLayout layout = new CardLayout();
	
	public CardPanel() {
		super();
		setLayout(layout);
		init();
		addMouseListener(this);
	}

	Color[] colors = { Color.YELLOW, Color.BLUE, Color.RED, Color.GREEN };
	private void init() {
		JPanel p;

		for (Color color : colors) {

			p = new JPanel();
			p.setBackground(color);
			add(p, color.toString());
		}

	}
	int index = 0;

	@Override
	public void mouseClicked(MouseEvent e) {
		index = index == colors.length - 1? 0 : index + 1;
		layout.show(this, colors[index].toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
