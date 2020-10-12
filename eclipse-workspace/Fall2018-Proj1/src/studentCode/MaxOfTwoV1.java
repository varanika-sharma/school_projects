package studentCode;

import java.util.Scanner;

public class MaxOfTwoV1 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);


		//YOUR CODE IN HERE
		int value;
		value = myScanner.nextInt();
		int value2;
		value2 = myScanner.nextInt();
		if (value > value2) {
			System.out.println(value+ " is greater than "+value2);
		}
		if (value <= value2 ) {
			System.out.println(value2+" is greater than or equal to "+value);
		}
		//YOUR CODE IN HERE


		myScanner.close();
	}


}
