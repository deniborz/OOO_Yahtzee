package controller;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import domain.model.Dice;
import domain.model.Facade;
import view.DiceLabel;
import view.GameView;

public class PlayerFieldController extends MainController implements ActionListener {

	DiceLabel[] dice = new DiceLabel[5];

	public PlayerFieldController(GameView gameView, Facade facade) {
		super(gameView, facade);
		dice[0] = new DiceLabel(0, null);
		dice[1] = new DiceLabel(1, null);
		dice[2] = new DiceLabel(2, null);
		dice[3] = new DiceLabel(3, null);
		dice[4] = new DiceLabel(4, null);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(getFacade().getGame().getRolls()<3) {
			rollDice(e);
		}
	}
	
	public void rollDice(ActionEvent e) {
		
		JButton diceButton = (JButton) e.getSource();
		
		int teller = 0;
		for (int i = 0;i<dice.length;i++) {
			if (getFacade().getCurrentPlayer().getField().getDice()[i].getActiveToString().equals("INACTIVE"))teller++;
			
		}
		if(teller == 5) diceButton.setEnabled(false);
		
		for (int i = 0;i<dice.length;i++) {
			if(getFacade().getCurrentPlayer().getField().getDice()[i].getActive()) {
				if(this.dice[i] != null) getGameView().getContent().remove(this.dice[i]);
				int randomDice = ThreadLocalRandom.current().nextInt(1,7);
				this.dice[i] = new DiceLabel(i,new ImageIcon("C:\\Users\\denib\\Documents\\Workspace2\\OOO_Yahtzee\\src\\images\\" + randomDice + ".jpg"));
				getFacade().getCurrentPlayer().getField().setDice(i, new Dice(randomDice, i));
				this.dice[i].setText(getFacade().getCurrentPlayer().getField().getDice()[i].getActiveToString());
				diceButton.getParent().add(this.dice[i]);
				this.dice[i].addMouseListener(new DiceController(getGameView(), getFacade()));
			}
		}
		
		diceButton.getParent().revalidate();
		diceButton.getParent().repaint();
		
		getFacade().getGame().nextRoll();
		
		if(getFacade().getGame().getRolls()==3) {
			diceButton.setEnabled(false);
		}
		
	}

}
