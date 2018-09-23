import java.awt.Color;
import java.util.HashMap;
import java.util.Map;


public class MyCritter extends Critter {
	
	private static Map<String, Map<Attack, Integer>> losses = new HashMap<>();
	
	private String lastOpponent;
	private Attack lastAttack;
	
	public boolean eat() {
		String n = getNeighbor(Direction.NORTH);
		
		if (n.equals(" ")) {
			return true;
		}
		
		return false;
	}

	public Attack fight(String opponent) {
		lastOpponent = opponent;
		Attack a = Attack.FORFEIT;
		
		lastAttack = a;
		return a;
	}

	public Color getColor() {
		return Color.BLACK;
	}

	public Direction getMove() {
		return Direction.NORTH;
	}

	public String toString() {
		return "?";
	}
	
	public void lose() {
		if (!losses.containsKey(lastOpponent)) {
			losses.put(lastOpponent, new HashMap<>());
		}
		Attack opponentAttack = null;
		if (lastAttack == Attack.POUNCE) {
			opponentAttack = Attack.SCRATCH;
		}
		Map<Attack, Integer> counts = losses.get(lastOpponent);
		if (!counts.containsKey(opponentAttack)) {
			counts.put(opponentAttack, 1);
		} else {
			counts.put(opponentAttack, counts.get(opponentAttack) + 1);
		}
	}
}
