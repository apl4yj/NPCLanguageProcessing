import java.util.Scanner;

public class ForWhileFactorial {
	public static void main(String[] args) {
		System.out.print("Compute the factorial of what number?: ");
		Scanner myKeyboard = new Scanner(System.in);
		int a = myKeyboard.nextInt();
		int fact = 1;
		int s = 1;
		
		for(s=1; s<=a; s++) {
			fact = s*fact;
			
		}
		System.out.println(fact);

		while(s<=a) {
			fact *= s;
		}
		System.out.println(fact);

	}
}
