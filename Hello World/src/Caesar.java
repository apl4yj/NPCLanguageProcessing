import java.util.Scanner;

public class Caesar {
	public static void main(String[] args) {
		Scanner myKeyboard = new Scanner(System.in);
		
		System.out.print("Please give me the ciphertext: ");
		String code = myKeyboard.nextLine();
		
		String news="";
		for (int i = 0; i <code.length(); i++) {
			news += (char)(code.charAt(i) - 1);
			i = i+1;
			news += (char)(code.charAt(i) - 9);
			i = i+1;
			news += (char)(code.charAt(i) - 2);
			i = i+1;
			news += (char)(code.charAt(i) - 4);

			
		}
		
		System.out.println("The ciphertext is: " + news);
	}
}
