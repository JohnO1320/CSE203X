
public class Shape {
	
	// fields
	public int numSides;
	public double area;
	
	// constructors
	public Shape() {
		this(0, 0.0);
	}
	
	public Shape(int numSides, double area) {
		this.numSides = numSides;
		this.area = area;
	}
	
	// method
	public String toString() {
		return "numSides = " + numSides + ", area = " + area;
	}
}
