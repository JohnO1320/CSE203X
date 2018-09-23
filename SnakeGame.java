import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class SnakeGame {
	
	public static final double SPEED = 0.5;
	
	public static final int WIDTH = 13;
	public static final int HEIGHT = 9;
	public static final int SIZE = 50;

	private DrawingPanel p;
	private Graphics g;
	private Snake snake;
	
	private Random r;
	private Point food;
	
	private boolean gameOver;
	
	public SnakeGame() {
		// set up graphics
		p = new DrawingPanel(WIDTH * SIZE, HEIGHT * SIZE);
		g = p.getGraphics();
		g.setFont(new Font("Times Roman", Font.PLAIN, 30));
		
		// initialize snake and generate food
		snake = new Snake(WIDTH / 2, HEIGHT / 2);
		r = new Random();
		generateFood();
		
		// add key listener
		p.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				snake.changeDirection(e.getKeyCode() - KeyEvent.VK_LEFT);
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		
		// move the snake SPEED times per second, redraw the graphics
		TimerTask task = new TimerTask() {
	        public void run() {
	        	if (!gameOver) {
	        		// move snake one spot
	        		gameOver = snake.move(food);
	        		
	        		if (snake.body.get(0).equals(food)) {
	        			generateFood();
	        		}
	        		
	        		// redraw
		            draw();
	        	}
	            
	        }
	    };
	    Timer timer = new Timer();
	    long delay = (long) (1000 * SPEED);
	    timer.schedule(task, delay, delay);
	}
	
	public void generateFood() {
		Point newFood = new Point();
		do {
			newFood.x = r.nextInt(WIDTH);
			newFood.y = r.nextInt(HEIGHT);

		} while (snake.body.contains(newFood));
		
		food = newFood;
	}
	
	public void draw() {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH * SIZE, HEIGHT * SIZE);		
		
		if (!gameOver) {
			g.setColor(Color.GREEN);
			for (Point p : snake.body) {
				g.fillRect(p.x * SIZE, p.y * SIZE, SIZE, SIZE);
			}
			
			g.setColor(Color.RED);
			g.fillRect(food.x * SIZE, food.y * SIZE, SIZE, SIZE);
		} else {
			g.setColor(Color.BLACK);
			g.drawString("Game Over", WIDTH / 2 * SIZE - 55, HEIGHT / 2 * SIZE);
		}
		
		g.setColor(Color.BLACK);
		g.drawString("Score: " + (snake.body.size() - 1), 50, 50);
	}
	
	public static void main(String[] args) {
		new SnakeGame();
	}
}
