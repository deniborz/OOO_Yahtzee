package domain.model;

import java.util.Arrays;

public enum Category {

	ACES(1),
	TWOS(2),
	THREES(3),
	FOURS(4),
	FIVES(5),
	SIXES(6),
	THREE_OF_A_KIND(3),
	FOUR_OF_A_KIND(4),
	FULL_HOUSE(5),
	SMALL_STRAIGHT(4),
	LARGE_STRAIGHT(5),
	YAHTZEE(50),
	CHANCE(5);
	
	public static String[] getNames(Class<? extends Enum<?>> e) {
	    return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}
	
	private int value;
	
	Category(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
}


