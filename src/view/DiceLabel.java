package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class DiceLabel extends JLabel {

	private int positionX;
	private boolean active = true;;
	
	public DiceLabel(int positionX, ImageIcon image) {
		super(image);
		this.positionX = positionX;
	}
	
	public int getPositionX() {
		return positionX;
	}

	public boolean isActive() {
		return active;
	}

	public void changeActive() {
		if(active) active = false;
		else active = true;
	}
	
	
	
}
