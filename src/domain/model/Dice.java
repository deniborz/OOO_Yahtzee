package domain.model;

public class Dice {

	private int[] numbers = {1,2,3,4,5,6};
	private int activeNumber;
	boolean active = true;
	int positionX;
	
	public Dice() {
		setActiveNumber(1);
	}
	
	public Dice(int activeNumber) {
		setActiveNumber(activeNumber);
	}
	
	public Dice(int activeNumber, int positionX) {
		setActiveNumber(activeNumber);
		setPositionX(positionX);
	}

	public int getActiveNumber() {
		return activeNumber;
	}

	private void setActiveNumber(int activeNumber) {
		this.activeNumber = activeNumber;
	}
	
	public void changeActive() {
		if (active) active = false;
		else active = true;
	}
	
	public boolean getActive() {
		return active;
	}
	
	public String getActiveToString() {
		if(active) {
			return "ACTIVE";
		}
		else return "INACTIVE";
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	
	
	
}
