
public class TestReview {
	public static void main(String[] args) {
		System.out.println(true || false);
		
		char a = 'A';
		System.out.println(a);
		
		//index, char.At
		
		String name = "Sherriff";
		char firstChar = name.charAt(0);
		System.out.println(firstChar);
		
		//Parse.int, turns word into number
		
		String number = "40";
		int number2 = Integer.parseInt(number);
		System.out.println(number2);
		
		int index = name.indexOf("rr");
		System.out.println(index);
		
		// switch statements are used when there is a specified number of inputs, telephone example where there are 3 examples, they 
		// are terrible at ranges of numbers, inputting 'y' or 'n' is better.
		
		//substring, any given string
		
		String sub = name.substring(3,5);
		System.out.println(sub);
		
		//else if, if you are going to check another condition
		
		int g = (int) 'p';
		System.out.print(g);
		
	//	int i = 1.0/3.0;
	//	System.out.print((double) i );
	}

}
