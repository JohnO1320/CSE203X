import java.util.*;

public class GuessingGameF {
	
	public static final int MAX_NUMBER = 10;
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String playAgain = "y";
		while (playAgain.startsWith("y")) {
			playGame(input);
			System.out.print("Do you want to play again? ");
			playAgain = input.next().toLowerCase();
		}
		
	}
	
	public static void playGame(Scanner input) {
		Random r = new Random();
		
		int answer = r.nextInt(MAX_NUMBER) + 1;
		int guess = -1;
		
		int numGuesses =  8;
		
		System.out.println("I'm thinking of a number... You have " + numGuesses + " guesses.");
		
		while (guess != answer && numGuesses > 0) {
			System.out.print("Guess a number [1-" + MAX_NUMBER + "]: ");
			guess = input.nextInt();
			if (guess < 1 || guess > 100) {
				System.out.println("Invalid guess.");
				continue;
			} else {
				numGuesses--;
			}
			
			if (guess < answer) {
				System.out.println("Too low.");
			} else if (guess > answer) {
				System.out.println("Too high.");
			}
			
			if (numGuesses > 1 && guess != answer) {
				System.out.println(numGuesses + " guesses remaining.");
			} else if (numGuesses == 1 && guess != answer) {
				System.out.println("Last guess...");
			}
		}
		if (numGuesses == 0) {
			System.out.println("Game over, the answer was " + answer + ".");
		} else {
			System.out.println("You win!");
		}
	}
}
