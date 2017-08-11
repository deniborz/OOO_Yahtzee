package domain.model.observer;

import domain.model.observer.PlayerTurnObserver;

public interface PlayerTurnObservable {

	void addTurnObserver(PlayerTurnObserver turnObserver);

    void removeTurnObserver(PlayerTurnObserver turnObserver);

    void notifyNextPlayerTurn();
	
}
