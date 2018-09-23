import java.awt.Color;
import java.awt.Graphics;

// smartcodingschool.com/DrawingPanel.java

public class GraphicsDemo {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(600, 600);
		Graphics g = panel.getGraphics();		
		g.setColor(Color.RED);
		g.fillRect(0, 0, 50, 50);
		
		g.setColor(Color.BLACK);
		panel.onDrag((x, y) -> draw(x, y, g));
		panel.onClick((x, y) -> changeColor(x, y, g));
	}
	
	public static void draw(int x, int y, Graphics g) {
		g.fillOval(x - 10, y - 10, 20, 20);
	}
	
	public static void changeColor(int x, int y, Graphics g) {
		if (x < 50 && y < 50) {
			g.setColor(Color.RED);
		}
	}
}
