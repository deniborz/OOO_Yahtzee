package domain.model;

public class Player {

	private String name;
	private int score;
	private Field field;
	
	public Player(String name) {
		setName(name);
		setScore(0);
		setField(new Field());
	}
	
	public String getName() {
		return name;
	}
	
	private void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	private void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score) {
		setScore(this.score+score);
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}
	
}
