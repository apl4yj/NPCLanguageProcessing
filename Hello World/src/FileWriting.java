import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

public class FileWriting {
	public static void main(String[] args) throws Exception {
		
		URL website = new URL("http://www.cs.virginia.edu/~sherriff/cs1110/weather.txt");
		Scanner web = new Scanner(website.openStream());
		PrintWriter output = new PrintWriter("Weather.txt");
		
		String city;
		String day;
		String month;
		String date;
		String year;
		String high;
		String low;
		
		while (web.hasNextLine()) {
			city = web.nextLine();
			day = web.nextLine();
			month = web.nextLine();
			date = web.nextLine();
			year = web.nextLine();
			high = web.nextLine();
			low = web.nextLine();

			write 


		}
		
		
		
		/**while(web.hasNextLine()); {
			String line = web.nextLine();
			System.out.println(line);
		}


		output.close();
		*/
	}
}
