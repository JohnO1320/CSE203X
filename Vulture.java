import java.awt.Color;

public class Vulture extends Bird {
	
	private boolean hungry;
	
	public Vulture() {
		hungry = true;
	}
	
	public boolean eat() {
		if (hungry) {
			hungry = false;
			return true;
		}
		return false;
	}
	
	public Attack fight(String opponent) {
		hungry = true;
		return super.fight(opponent);
	}
	
	public Color getColor() {
		return Color.BLACK;
	}
}
