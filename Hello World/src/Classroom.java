import java.util.Scanner;

public class Classroom {
	public static void main(String[] args) {
		Scanner myKeyboard = new Scanner(System.in);
		
		System.out.print("How many students are in the class");
		int x = myKeyboard.nextInt();
		// easier
		if (x >= 350) {
			System.out.println("Full");
		}	else {
			System.out.println("Not Full");
		}
		
		
/**		
		Harder, more computations
		
		if(x >= 350) {
			System.out.print("The class is full");
	}
		if(x < 350) {
			System.out.print("Not Full");
		}
	*/
	
	//>= 350, class is full
	//if not, class is empty
}
}
