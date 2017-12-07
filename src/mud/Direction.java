package mud;

import java.util.stream.IntStream;

/**
 * The directional inputs that the MUD understands.
 */
public enum Direction {
	NORTH, SOUTH, EAST, WEST;

	public static final int count = Direction.values().length;

	private static final int northIndex = 0;
	private static final int southIndex = 2;
	private static final int westIndex  = 1;
	private static final int eastIndex  = 3;

	public int index() {
		switch (this) {
			case NORTH: return northIndex;
			case SOUTH: return southIndex;
			case WEST:	return westIndex;
			case EAST:	return eastIndex;
			default: throw new AssertionError();
		}
	}

	public static IntStream indices() {
		return IntStream.of(northIndex,southIndex,westIndex,eastIndex);
	}

	/**
	 * Maps an input String to a Direction value.
	 * This method is intended to be where synonymous inputs
	 * are mapped to a single Direction.
	 * @param input The input, typically from the end user. Should not be null.
	 * @return A Direction value, or null if unable to map input to a Direction.
	 */
	public static Direction resolve(String input) {
		Direction result;

		switch (input.toUpperCase()) {
			case "UP":
			case "NORTH":
				result = Direction.NORTH;
				break;
			case "DOWN":
			case "SOUTH":
				result = Direction.SOUTH;
				break;
			case "RIGHT":
			case "EAST":
				result = Direction.EAST;
				break;
			case "LEFT":
			case "WEST":
				result = Direction.WEST;
				break;
			default:
				result = null;
				break;
		}

		return result;
	}

}