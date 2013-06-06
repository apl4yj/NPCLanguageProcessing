
public class Mar12TwoDArray {

		public static void main(String[] args) {
			
			//int[] intArray = new int[9];
			//before [] is the data type of whats in the array
			int[][] twoDArray = new int [8][9];
			//ragged array means each column might have a different number of rows
			int traceSum = 0;
			
			for (int i = 0; i < twoDArray.length; i ++) {
				for(int j = 0; j < twoDArray[i].length; j++) {
					twoDArray[i][j] = i*j;
				}
			}
			for (int i = 0; i < twoDArray.length; i ++) {
				for(int j = 0; j < twoDArray[i].length; j++) {
					System.out.print(twoDArray[i][j] + " ");
					for(int x=0; x<i; x++) {		
					}
				}
				System.out.println();
				}
			
			//calculating trace
			for(int i = 0; i < twoDArray.length; i++) {
				traceSum += twoDArray[i][i];
			}
			System.out.println(traceSum);
		}
}
