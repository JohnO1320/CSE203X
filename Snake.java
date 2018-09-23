import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Snake {
	
	private int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
	
	public List<Point> body;
	public int[] dir;
	
	public Snake(int x, int y) {
		body = new ArrayList<>();
		body.add(new Point(x, y));
		
		dir = DIRECTIONS[0];
	}
	
	public boolean move(Point food) {
		Point head = body.get(0);
		Point newHead = new Point(head.x + dir[0], head.y + dir[1]);
		
		if (!body.contains(newHead) && newHead.x >= 0 && newHead.x < SnakeGame.WIDTH &&
		                               newHead.y >= 0 && newHead.y < SnakeGame.HEIGHT) {
			body.add(0, newHead);
			if (!newHead.equals(food)) {
				body.remove(body.size() - 1);
			}
			return false;
			
		}
		return true;
	}
	
	public void changeDirection(int d) {
		dir = DIRECTIONS[d];
	}
	
}
