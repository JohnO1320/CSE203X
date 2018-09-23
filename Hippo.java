import java.awt.Color;
import java.util.Random;

public class Hippo extends Critter {
	
	private static final Direction[] DIRS = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
	
	private Random r;
	private int hunger;
	private int step;
	private int dir;
	
	public Hippo(int hunger) {
		this.hunger = hunger;
		r = new Random();
	}
	
	public boolean eat() {
		if (hunger > 0) {
			hunger--;
			return true;
		}
		return false;
	}

	public Attack fight(String opponent) {
		return hunger > 0 ? Attack.SCRATCH : Attack.POUNCE;
	}

	public Color getColor() {
		return hunger > 0 ? Color.GRAY : Color.WHITE;
	}

	public Direction getMove() {
		if (step % 5 == 0) {
			dir = r.nextInt(DIRS.length);
		}
		step++;
		return DIRS[dir];
	}

	public String toString() {
		return "" + hunger;
	}
}
