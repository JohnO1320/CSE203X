import java.awt.Color;
import java.awt.Graphics;

// smartcodingschool.com/DrawingPanel.java
// https://pastebin.com/L2fuHMU5

public class TicTacToe {
	
	// class constants
	public static final int SIZE = 200;
	
	public static final int EMPTY = 0;
	public static final int X = 1;
	public static final int O = -1;
	
	public static final int PLAY = 0;
	public static final int TIE = 10;
	
	// global variables
	public static int currentPlayer = X;
	public static int gameState = PLAY;
	
	public static void main(String[] args) {
		// create a DrawingPanel
		DrawingPanel panel = new DrawingPanel(3 * SIZE, 3 * SIZE);
		Graphics g = panel.getGraphics();
		
		// create the board and draw it
		int[][] board = new int[3][3];
		drawBoard(board, g);
		
		// create mouse click listener
		panel.onClick((x, y) -> click(x, y, board, g));
	}
	
	// this method is run whenever the DrawingPanel is clicked
	public static void click(int x, int y, int[][] board, Graphics g) {
		if (gameState == PLAY) {
			// convert x and y coordinate where mouse click occured
			// to the row and column of the board spot clicked
			int row = y / SIZE;
			int col = x / SIZE;
			
			if (board[row][col] == EMPTY) {
				// set the board spot to the current player
				board[row][col] = currentPlayer;
				if (hasWon(currentPlayer, row, col, board)) {
					gameState = currentPlayer;
					System.out.println(str(currentPlayer) + " wins!");
				} else if (isTie(board)) {
					gameState = TIE;
					System.out.println("Tie...");
				}
				
				// switch player
				currentPlayer = (X + O) - currentPlayer;
				
				// update panel
				drawBoard(board, g);
			}
		} else {
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					board[i][j] = EMPTY;
				}
			}
			
			currentPlayer = X;
			gameState = PLAY;
			drawBoard(board, g);
		}
	}
	
	public static boolean hasWon(int player, int row, int col, int[][] b) {
		// check rows and columns
		int rowSum = b[row][0] + b[row][1] + b[row][2];
		if (rowSum == player * 3) return true;
		
		int colSum = b[0][col] + b[1][col] + b[2][col];
		if (colSum == player * 3) return true;
		
		int diagSum = b[0][0] + b[1][1] + b[2][2];
		if (diagSum == player * 3) return true;
		
		diagSum = b[0][2] + b[1][1] + b[2][0];
		if (diagSum == player * 3) return true;

		return false;
	}
	
	public static boolean isTie(int[][] board) {
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				if (board[row][col] == EMPTY) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void drawBoard(int[][] board, Graphics g) {
		// clear panel
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 3 * SIZE, 3 * SIZE);
	    g.setColor(Color.BLACK);
	    
		// draws grid lines
		g.drawLine(SIZE, 0, SIZE, 3 * SIZE);
		g.drawLine(2 * SIZE, 0, 2 * SIZE, 3 * SIZE);
		g.drawLine(0, SIZE, 3 * SIZE, SIZE);
		g.drawLine(0, 2 * SIZE, 3 * SIZE, 2 * SIZE);
		
		// draw X's and O's
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				
				int x = col * SIZE;
				int y = row * SIZE;
				int q = SIZE / 4;
				
				if (board[row][col] == X) {
					g.drawLine(x + q, y + q, x + SIZE - q, y + SIZE - q);
					g.drawLine(x + SIZE - q, y + q, x + q, y + SIZE - q);
				} else if (board[row][col] == O) {
					g.drawOval(x + q, y + q, SIZE / 2, SIZE / 2);
				}
			}
		}
	}
	
	public static void printBoard(int[][] b) {
		// prints a string version of the board to the console
		System.out.println(" " + str(b[0][0]) + " | " + str(b[0][1]) + " | " + str(b[0][2]) + " ");
		System.out.println("---+---+---");
		System.out.println(" " + str(b[1][0]) + " | " + str(b[1][1]) + " | " + str(b[1][2]) + " ");
		System.out.println("---+---+---");
		System.out.println(" " + str(b[2][0]) + " | " + str(b[2][1]) + " | " + str(b[2][2]) + " ");
	}
	
	// converts int to String version
	public static String str(int n) {
		if (n == X) return "X";
		if (n == O) return "O";
		return " ";
	}

}