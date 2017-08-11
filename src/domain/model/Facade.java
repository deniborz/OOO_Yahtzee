package domain.model;

public class Facade {

	private Game game;
	
	public Facade() {
		this.game = new Game();
	}
	
	public void setGame(Game game) {
		this.game = game;
    }

    public Game getGame() {
        return game;
    }
	
	public void addPlayer(String name) {
        game.addPlayer(name);
    }

    public Player getPlayer(String name) {
        return game.getPlayer(name);
    }
    
    public Player[] getPlayers() {
        return game.getPlayers();
    }

    public Player getCurrentPlayer() {
        return game.getPlayerTurn();
    }

    public void nextTurn() {
        game.nextTurn();
    }
    
    public void nextRoll() {
        game.nextRoll();
    }
    
    public void resetRolls() {
        game.resetRolls();
    }


	public void setPlayersAmount(int playersAmount) {
		game.setPlayersAmount(playersAmount);
	}


	
}
