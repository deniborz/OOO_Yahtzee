package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import domain.model.Facade;
import view.GameView;

public class PointsController extends MainController implements ActionListener {

	public PointsController(GameView gameView, Facade facade) {
		super(gameView, facade);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("het wordt toch uitgevoerd?");
		int teller = 0;
		for(int i = 0;i<5;i++) {
			/*if(!super.getFacade().getCurrentPlayer().getField().getDice()[i].getActive() 
					&& super.getFacade().getCurrentPlayer().getField().getDice()[i].getActiveNumber() == super.ge);*/
			//code om punten te krijgen
		}
		super.getFacade().nextTurn();
		super.getGameView().nextTurn(super.getFacade().getGame());
	}

}
