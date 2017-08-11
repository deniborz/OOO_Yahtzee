package domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import domain.model.observer.PlayerFieldObservable;
import domain.model.observer.PlayerFieldObserver;

public class Field implements PlayerFieldObservable {

	private Dice[] dice = new Dice[5];
	private Player player;
	private List<PlayerFieldObserver> fieldObservers = new ArrayList<>();

	public Field() {
		dice[0] = new Dice();
		dice[1] = new Dice();
		dice[2] = new Dice();
		dice[3] = new Dice();
		dice[4] = new Dice();
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public void setDice(int index, Dice dice) {
		this.dice[index] =  dice;
	}
	
	public Dice[] getDice() {
		return this.dice;
	}
	
	public void rollDice() {
		notifyUpdateField();
	}

	@Override
	public void addFieldObserver(PlayerFieldObserver fieldObserver) {
		fieldObservers.add(fieldObserver);
	}

	@Override
	public void removeFieldObserver(PlayerFieldObserver fieldObserver) {
		fieldObservers.remove(fieldObserver);
		
	}

	@Override
	public void notifyUpdateField() {
		for (PlayerFieldObserver playerFieldObserver : fieldObservers) {
			playerFieldObserver.updateField(this);
		}
	}

}
