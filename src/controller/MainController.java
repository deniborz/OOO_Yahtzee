package controller;

import domain.model.Facade;
import view.GameView;

public class MainController {

	private GameView gameView;
	private Facade facade;

	public MainController(GameView gameView, Facade facade) {
		setFacade(facade);
		setGameView(gameView);
	}

	public Facade getFacade() {
		return facade;
	}

	public void setFacade(Facade facade) {
		this.facade = facade;
	}
	
	public GameView getGameView() {
		return gameView;
	}

	public void setGameView(GameView gameView) {
		this.gameView = gameView;
	}

	public void start() {
		gameView.setController(this);
		gameView.startConfig();
	}
	
}
