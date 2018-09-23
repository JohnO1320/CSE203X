
public class Triangle extends Shape {
	
	public int height;
	public int base;
	
	public Triangle(int base, int height) {
		super(3, 0.5 * base * height);
		this.base = base;
		this.height = height;
	}
	
	public String toString() {
		return super.toString() + ", base = " + base + ", height = " + height;
	}
	
	
}
