
public class Point {
	
	public int x;
	public int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point() {
		this(0, 0);
	}
	
	public boolean equals(Object o) {
		Point other = (Point) o;
		return this.x == other.x && this.y == other.y;
	}
	
	public int hashCode() {
		return x + 31 * y;
	}
}
