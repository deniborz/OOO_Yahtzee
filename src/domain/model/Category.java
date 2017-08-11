package domain.model;

import java.util.Arrays;

public enum Category {

	ACES,
	TWOS,
	THREES,
	FOURS,
	FIVES,
	SIXES,
	THREE_OF_A_KIND,
	FOUR_OF_A_KIND,
	FULL_HOUSE,
	SMALL_STRAIGHT,
	LARGE_STRAIGHT,
	YAHTZEE,
	CHANCE;
	
	public static String[] getNames(Class<? extends Enum<?>> e) {
	    return Arrays.stream(e.getEnumConstants()).map(Enum::name).toArray(String[]::new);
	}
	
}


