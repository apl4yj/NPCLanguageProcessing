import java.util.Scanner;

public class BMI {
	public static void main(String[] args) {
		Scanner myKeyboard = new Scanner(System.in);
		System.out.print("what is your height in inches?: ");
		double height = myKeyboard.nextDouble();
		System.out.print("What is your weight in pounds?: ");
		double kgs = myKeyboard.nextDouble();
		double BMI = (703*kgs)/(Math.pow(height, 2));
		System.out.println(BMI);
		
		if(BMI>40) {
			System.out.println("You are in the obese class 3");
		} else if(BMI>=35) {
			System.out.println("You are in the obese class 2");
		} else if(BMI>=30) {
			System.out.println("You are in the obese class 1");
		}	else if(BMI>=25) {
			System.out.println("You are overweight");
		}	else if(BMI>=18.5) {
			System.out.println("You are normal");
		}	else if(BMI>=16) {
			System.out.println("You are underweight");
		}	else {
			System.out.println("You are severely underweight");
}	
}
}