import java.awt.Color;

public class Bird extends Critter {
	
	private static final Direction[] DIRS = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
	private static final String[] STRINGS = {"^", ">", "V", "<"};
	
	private int step;

	public Attack fight(String opponent) {
		return opponent.equals("%") ? Attack.ROAR : Attack.POUNCE;
	}

	public Color getColor() {
		return Color.BLUE;
	}

	public Direction getMove() {
		return DIRS[(step++ / 3) % DIRS.length];
	}

	public String toString() {
		return STRINGS[((step - 1) / 3) % STRINGS.length];
	}
}
