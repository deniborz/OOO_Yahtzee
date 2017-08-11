package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import domain.model.Facade;
import view.DiceLabel;
import view.GameView;

public class DiceController extends MainController implements MouseListener {

	public DiceController(GameView gameView, Facade facade) {
		super(gameView, facade);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		DiceLabel diceLabel = (DiceLabel) e.getSource();
		getFacade().getCurrentPlayer().getField().getDice()[diceLabel.getPositionX()].changeActive();
		diceLabel.changeActive();
		diceLabel.setText(getFacade().getCurrentPlayer().getField().getDice()[diceLabel.getPositionX()].getActiveToString());
		
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
