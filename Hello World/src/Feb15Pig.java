import java.util.*;

public class Feb15Pig {
	public static void main(String[] args) {
		System.out.println("Welcome to Pig");
		
		Scanner myKeyboard = new Scanner(System.in);
		int player1Turn = 0;
		int player2Turn = 0;
		int player1Bank = 0;
		Random randomGenerator = new Random();
		int winningScore = 50;
		int player2Bank = 0;
		
		System.out.println("Player 1 rolls first");

		
		while(player1Bank < winningScore && player1Turn < winningScore && player2Bank < winningScore && player2Turn < winningScore) {
			int rand = randomGenerator.nextInt(6) + 1;
			System.out.println("Player 1's Bank is: "+ player1Bank);
			System.out.println("Player 1 rolled a: " + rand);

			if(rand == 1) {
				// turn over
				System.out.println("Pig!");
				System.out.println("\n");
				player1Turn = 0; }
				
			 else {
				player1Turn += rand;
				System.out.println("Player 1's score: " + player1Turn);
				System.out.println("Roll or Bank?");
				char y = myKeyboard.nextLine().toLowerCase().charAt(0);
				
					if(y == 'r') {
						System.out.println("You want to roll");
					} else {
						System.out.println("You want to bank");
						player1Bank = player1Turn + player1Bank;
						player1Turn = 0;
					}
			 }
			}
				
			
		
			System.out.println("Player 1 wins!");
	}
}
