import java.awt.Color;

public class Ant extends Critter {
	
	private boolean walkSouth;
	private boolean vertical;
	
	public Ant(boolean walkSouth) {
		this.walkSouth = walkSouth;
		this.vertical = true;
	}
	
	public boolean eat() {
		return true;
	}

	public Attack fight(String opponent) {
		return Attack.SCRATCH;
	}

	public Color getColor() {
		return Color.RED;
	}

	public Direction getMove() {
		vertical = !vertical;
		if (!vertical) {
			return Direction.EAST;
		} else if (walkSouth) {
			return Direction.SOUTH;
		} else {
			return Direction.NORTH;
		}
	}

	public String toString() {
		return "%";
	}
}
