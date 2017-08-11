package domain.model;

import java.util.ArrayList;
import java.util.List;

import domain.model.observer.PlayerTurnObservable;
import domain.model.observer.PlayerTurnObserver;

public class Game implements PlayerTurnObservable {
	
	private Player[] players;
	private int playersSize = 0;
	private int playersAmount;
	private int playerTurn = 0;
	private int rolls = 0;
	
	private List<PlayerTurnObserver> turnObservers = new ArrayList<>();
	
	public Game() {
	}

	public void addPlayer(String name) {
		if(name != null && !name.trim().isEmpty() && playersSize < 5){
			Player player = new Player(name);
			players[playersSize] = player;
			playersSize++;
		}
    }

    public Player getPlayer(String name) {
        for (Player player : players) {
            if(player != null) {
                if(player.getName().equals(name)) return player;
            }
        }
        throw new RuntimeException(name + " can not be found!");
    }
    
    public Player[] getPlayers() {
    	return players;
    }

    
    public int getPlayersSize() {
		return playersSize;
	}

	public void setPlayersSize(int playersSize) {
		this.playersSize = playersSize;
	}

	public int getPlayersAmount() {
		return playersAmount;
	}

	public void setPlayersAmount(int playersAmount) {
		this.playersAmount = playersAmount;
		players = new Player[playersAmount];
	}

	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}

	public Player getPlayerTurn() {
        return players[playerTurn];
    }

    public void nextTurn() {
        if(playerTurn != playersAmount-1) {
        	playerTurn++;
        }
        else playerTurn = 0;
        notifyNextPlayerTurn();
    }
    
    public int getRolls() {
		return this.rolls;
	}
    
    public void nextRoll() {
		rolls++;
	}
    
    public void resetRolls() {
		rolls = 0;
	}

	@Override
	public void addTurnObserver(PlayerTurnObserver turnObserver) {
		turnObservers.add(turnObserver);
	}

	@Override
	public void removeTurnObserver(PlayerTurnObserver turnObserver) {
		turnObservers.remove(turnObserver);
	}

	@Override
	public void notifyNextPlayerTurn() {
		for (PlayerTurnObserver playerTurnObserver : turnObservers) {
			playerTurnObserver.nextTurn(this);
		}
	}
	
}
