import java.util.Scanner;

public class Telephone {

	public static void main(String[] args) {

		Scanner myKeyboard = new Scanner(System.in);
		System.out.println("1: Pharmacy, 2: Office, 3: Refill");
		int input = myKeyboard.nextInt();
				
	switch(input) {	
	
	case 9:
	case 10:
	case 8:
	case 1: 
		System.out.println("Hello Pharmacy");
		break;
	case 2:
		System.out.println("Hello Office");
		break;
	case 3:
		System.out.println("Hello Refill");
		break;
	default:
		System.out.println("Hello ring tone...");
	}

}
}