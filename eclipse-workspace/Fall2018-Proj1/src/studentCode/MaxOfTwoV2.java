package studentCode;

import java.util.Scanner;

public class MaxOfTwoV2 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		
		//YOUR CODE IN HERE
		
		int value;
		value = myScanner.nextInt();
		int value2;
		value2 = myScanner.nextInt();
		if (value > value2) {
			System.out.println(value + " is greater than "  + value2);
		}
		else if (value < value2 ) {
			System.out.println(value2 +" is greater than  " +value);
		}
		else if (value2 == value) {
			System.out.println(value+" is equal to "+value2);

		}
		//YOUR CODE IN HERE
		
		
		myScanner.close();
	}
	
	
}
