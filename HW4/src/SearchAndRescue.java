/**
* Names: Andrew Leach, Fielding Harrison
* Computing IDs: apl4yj, flh6bz
* Lab Section: 104  
* Date: 3/27/2012
*/

import java.io.File;
import java.text.DecimalFormat;
import java.util.*;

public class SearchAndRescue {
	
	public static void main(String[] args) throws Exception{
		
		DecimalFormat formatter = new DecimalFormat("#.0000");

		ArrayList<Double> latitude = new ArrayList<Double>();
		ArrayList<Double> longitude = new ArrayList<Double>();
		ArrayList<String> time = new ArrayList<String>();

		System.out.println("What is the file name you wish to open?");
		Scanner myKeyboard = new Scanner(System.in);
		String fileName = myKeyboard.next();
		System.out.println();
		
		double dist = 0;
		
		File file = new File(fileName);
		Scanner inputFile = new Scanner(file);

		System.out.println("--- Hike Analysis ---");
		System.out.println("File: " + fileName);
		System.out.println();
		
		int pointTotal = 0;
		
		while (inputFile.hasNext()) {
			String str = inputFile.nextLine();
			String coord[] = str.split(",");
			String times = coord[2];
			String coordtime[] = times.split(" ");
			latitude.add(Double.parseDouble(coord[0]));
			longitude.add(Double.parseDouble(coord[1]));
			time.add(coordtime[1]);
			pointTotal ++;
		}
		
		for(int i = 0; i<=latitude.size()-2; i++) {
			HW4Util util = new HW4Util();
			double lat1 = latitude.get(i);
			double lon1 = longitude.get(i);
			double lat2 = latitude.get(i+1);
			double lon2 = longitude.get(i+1);
			dist += util.distance( lat1,  lon1,  lat2,  lon2);
		}
		System.out.println("Total distance traveled: " + formatter.format(dist) + " miles");
			
		int totTime = 0;
		
		for(int i = 0; i<=time.size()-2; i++){
				
			String hrmin1 = time.get(i);
			String[] split = hrmin1.split(":");
			
			String hrmin2 = time.get(i+1);
			String[] split2 = hrmin2.split(":");
			
			double hour1 = Double.parseDouble(split[0]);
			double minute1 = Double.parseDouble(split[1]);
			double second1 = Double.parseDouble(split[2]);
			
			double hour2 = Double.parseDouble(split2[0]);
			double minute2 = Double.parseDouble(split2[1]);
			double second2 = Double.parseDouble(split2[2]);
			
			double timeTotal = 3600*hour1 + 60*minute1 + second1;
			double timeTotal2 = 3600*hour2 + 60*minute2 + second2;
			
			double timeDiff = timeTotal2- timeTotal;
			totTime += timeDiff;
			}
		
		int totHour = totTime / 3600;
		int totMin = ((totTime % 3600) / 60);		
		int totSec = ((totTime % 3600) % 60);
		
		String totHourS = totHour + "";
		String totMinS = totMin + "";
		String totSecS = totSec + "";
		
		if(totHour < 10) {
			totHourS = "0" + totHourS;
		}
		if(totMin < 10) {
			totMinS = "0" + totMinS;
		}
		if(totSec < 10) {
			totSecS = "0" + totSec;
		}

		System.out.println("Total time traveled: " + totHourS +":" + totMinS + ":" + totSecS);
		
		double timeAverage = (totTime / (double) pointTotal) /60 ;
		System.out.println("Avg minutes between GPS markers: "+ formatter.format(timeAverage));

		double totFeet = dist * 5280.0;
		double totMinutes  = totTime / 60.0;
		System.out.println("Avg distance traveled in 1 min: " + formatter.format(totFeet/totMinutes) + " ft");
		
		System.out.println("1 hour search perimeter: " + formatter.format((totFeet/totMinutes)*60/5280) + " mi");
		System.out.println("2 hour search perimeter: " + formatter.format((totFeet/totMinutes)*120/5280) + " mi");
		
		//Starting the URL, Activity 7
		
		Scanner inputFile2 = new Scanner(file);
		String URLStart = "http://maps.googleapis.com/maps/api/staticmap?zoom=13&size=1100x1100&maptype=roadmap";	
		int count = 0;
		int scale  = pointTotal/15;
		while (inputFile2.hasNext()) {
			String str = inputFile2.nextLine();
			String coord[] = str.split(",");
			if (count % scale == 0){
				HW4Util util = new HW4Util();
				double lat1 = latitude.get(1);
				double lon1 = longitude.get(1);
				double lat2 = latitude.get(count);
				double lon2 = longitude.get(count);
				int dist2 = (int) util.distance( lat1,  lon1,  lat2,  lon2);
				URLStart = URLStart + "&markers=color:green|label:" + ((dist2)+1) +"|" + coord[0] + "," + coord[1];
			}
			count ++;	
		}
			String URLCircle = "";
			for (int i=0; i<=7; i++) {
			HW4Util util = new HW4Util();
			double[] coordinate = util.findCoordinate(latitude.get(pointTotal-1),longitude.get(pointTotal-1),  45*i,  (totFeet/totMinutes)*60/5280);
			double[] coordinate2 = util.findCoordinate(latitude.get(pointTotal-1),longitude.get(pointTotal-1),  45*i,  (totFeet/totMinutes)*120/5280);
			URLCircle = URLCircle + "&markers=color:red|label:S|" + coordinate[0] + "," + coordinate[1];
			URLCircle = URLCircle + "&markers=color:red|label:S|" + coordinate2[0] + "," + coordinate2[1];
		}
		HW4Util util = new HW4Util();
		String URLSearch = "";
		double finalBearing = util.getBearing(latitude.get(pointTotal-1),longitude.get(pointTotal-1),latitude.get(pointTotal-2),longitude.get(pointTotal-2)); 
		double[] finalCoord = util.findCoordinate(38.06959,-78.79411, finalBearing, (totFeet/totMinutes)*60/5280);
		URLSearch = "&markers=color:blue|label:P|" + finalCoord[0] + "," + finalCoord[1];

		URLCircle = URLCircle +URLSearch+ "&sensor=false";
		System.out.println(URLStart+URLCircle);
		util.createImage(URLStart+URLCircle);
		
		//BONUS ASSIGNMENT
		
		String URLCone = "";	

		for (int i=1; i<=6; i++) {
			double[] coordinateB = util.findCoordinate(latitude.get(pointTotal-1),longitude.get(pointTotal-1),  finalBearing + 30,  (totFeet/totMinutes)*i*20/5280);
			URLCone = URLCone + "&markers=color:red|label:S|" + coordinateB[0] + "," + coordinateB[1];
		}
		for (int i=1; i<=6; i++) {
			double[] coordinateB = util.findCoordinate(latitude.get(pointTotal-1),longitude.get(pointTotal-1),  finalBearing -30,  (totFeet/totMinutes)*i*20/5280);
			URLCone = URLCone + "&markers=color:red|label:S|" + coordinateB[0] + "," + coordinateB[1];
		}
		double[] coordinateB = util.findCoordinate(latitude.get(pointTotal-1),longitude.get(pointTotal-1),  finalBearing,  (totFeet/totMinutes)*120/5280);
		URLCone = URLCone + "&markers=color:red|label:S|" + coordinateB[0] + "," + coordinateB[1];

		URLCone = URLCone +URLSearch+ "&sensor=false";
		System.out.println();
		System.out.println("Bonus URL:");
		System.out.println(URLStart+URLCone);
		util.createImage(URLStart+URLCone);
			


			}
			

		}
	
