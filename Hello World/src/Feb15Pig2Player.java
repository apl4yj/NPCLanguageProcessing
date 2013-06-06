import java.util.*;

public class Feb15Pig2Player {
	public static void main(String[] args) {
		System.out.println("Welcome to Pig");
		
		Scanner myKeyboard = new Scanner(System.in);
		int player1Turn = 0;
		int player2Turn = 0;
		int player1Bank = 0;
		Random randomGenerator = new Random();
		int winningScore = 50;
		int player2Bank = 0;
		int fail1 = 0;
		int fail2 = 0;
		
		System.out.println("Player 1 rolls first");

		
		while(player1Bank < winningScore && player1Turn < winningScore && player2Bank < winningScore && player2Turn < winningScore) {
			while(fail1 != 1) {
			int rand = randomGenerator.nextInt(6) + 1;
			System.out.println("Player 1's Bank is: "+ player1Bank);
			System.out.println("Player 1 rolled a: " + rand);

			if(rand == 1) {
				// turn over
				System.out.print("Pig!");
				System.out.println("\n");
				player1Turn = 0;
				//player2Turn = 0;
				fail1++; }
				
			 else {
				player1Turn += rand;
				System.out.println("Player 1's score: " + player1Turn);
				System.out.println("Roll or Bank?");
				char y = myKeyboard.nextLine().toLowerCase().charAt(0);
				
					if(y == 'r') {
						System.out.println("You want to roll");
					} else {
						player1Bank = player1Turn + player1Bank;
						System.out.println("Player 1 banked. Bank Value: " + player1Bank);
						System.out.print("\n");
						player1Turn = 0;
						fail1++;
					}
			 }}
			//Start of Player 2's Turn
			while(fail2 != 1) {
			int rand = randomGenerator.nextInt(6) + 1;
			System.out.println("Player 2's Turn Begins");
			System.out.println("Player 2's Bank is: "+ player2Bank);
			System.out.println("Player 2 rolled a: " + rand);
			
			if(rand == 1) {
				System.out.println("Pig!");
				System.out.println("\n");
				player2Turn = 0; 
				fail2++; }
				
			 else {
				player2Turn += rand;
				System.out.println("Player 2's score: " + player2Turn);
				System.out.println("Roll or Bank?");
				char y = myKeyboard.nextLine().toLowerCase().charAt(0);
				
					if(y == 'r') {
						System.out.println("You want to roll");
					} else {
						System.out.println("You want to bank");
						player2Bank = player2Turn + player2Bank;
						player2Turn = 0;
						fail2++;
								
					}}
			 }
			fail1 = 0;
			fail2 = 0;
			}
				
		System.out.println("Someone's banked surpassed "+ winningScore);
		if (player1Bank > winningScore) {
			System.out.print("Player 1 Wins!");
		}  else {
			System.out.print("Player 2 Wins!");
		}
	}
}
