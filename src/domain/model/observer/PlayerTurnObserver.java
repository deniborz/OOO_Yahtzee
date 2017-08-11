package domain.model.observer;

import domain.model.Game;

public interface PlayerTurnObserver {

	void nextTurn(Game game);
	
}
