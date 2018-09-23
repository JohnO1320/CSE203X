import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Hangman {
	
	public static String answer;
	public static int numGuesses = 0;

	public static void main(String[] args) throws FileNotFoundException {
		answer = getRandomWord("dict.txt");
		
		Set<Character> validGuesses = new TreeSet<>();
		Set<Character> guessed = new HashSet<>();
		for (int i = 'a'; i <= 'z'; i++) {
			validGuesses.add((char) i);
		}
		
		DrawingPanel p = new DrawingPanel(1000, 600);
		Graphics g = p.getGraphics();
		p.onKeyUp(key -> makeGuess(key, validGuesses, guessed, g));
		
		String partial = getPartialSolution(guessed);
		draw(g, validGuesses, partial);
	}
	
	public static void makeGuess(char guess, 
			Set<Character> validGuesses, Set<Character> guessed, Graphics g) {
		guess = Character.toLowerCase(guess);
		
		if (validGuesses.contains(guess) && numGuesses < 5) {		
			
			guessed.add(guess);
			validGuesses.remove(guess);
			
			String partial = getPartialSolution(guessed);
			draw(g, validGuesses, partial);
		}
	}
	
	public static String getPartialSolution(Set<Character> guessed) {
		String result = "";
		for (int i = 0; i < answer.length(); i++) {
			char c = answer.charAt(i);
			if (!guessed.contains(c) && 'a' <= c && c <= 'z'){
				result += "_ ";
			} else {
				result += c + " ";
			}
		}
		return result;
	}
	
	public static void draw(Graphics g, Set<Character> validGuesses, String partial) {
		// clears the panel
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 1000, 600);
		g.setColor(Color.BLACK);
		
		
		g.setFont(new Font("Times Roman", Font.PLAIN, 30));
		g.drawString(validGuesses.toString(), 10, 50);
		g.drawString(partial, 10, 100);
		
	}
	
	public static String getRandomWord(String filename) throws FileNotFoundException {
		Scanner dict = new Scanner(new File(filename));
		List<String> phrases = new ArrayList<>();
		while (dict.hasNextLine()) {
			phrases.add(dict.nextLine());
		}
		dict.close();
		
		Random r = new Random();
		return phrases.get(r.nextInt(phrases.size()));
	}

}
