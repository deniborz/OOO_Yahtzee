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
		super.getFacade().nextTurn();
	}

}
