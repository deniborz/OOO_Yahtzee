package domain.model.observer;

public interface PlayerFieldObservable {

	void addFieldObserver(PlayerFieldObserver fieldObserver);

    void removeFieldObserver(PlayerFieldObserver fieldObserver);

    void notifyUpdateField();
	
}
