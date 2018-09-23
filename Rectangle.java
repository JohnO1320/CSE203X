
public class Rectangle extends Shape {
	
	public int width;
	public int height;
	
	public Rectangle(int width, int height) {
		super(4, width * height);
		
		this.width = width;
		this.height = height;
	}
	
	public String toString() {
		return super.toString() + ", width = " + width + ", height = " + height;
	}
}
