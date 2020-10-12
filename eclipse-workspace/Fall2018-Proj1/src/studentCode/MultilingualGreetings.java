package studentCode;

import java.util.Scanner;

public class MultilingualGreetings {
	private static String greetingString;
	

	//CODE ABOVE HERE IS GIVEN TO YOU - DO NOT ALTER IT
	//YOUR CODE SHOULD USE THE ABOVE VARIABLE 

	
	
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		
		
		//YOUR CODE IN HERE - THE COMMENTS ARE THERE TO HELP GUIDE YOU

		
		//Ask what language they would like to use.
System.out.print("1) English   2) Espanol   3) Francais: ");
	int langauge;
	langauge = myScanner.nextInt();
		//Based on the language selected above, set the greetingString 
		//  variable in that language.
	if (langauge == 1) {	
		greetingString = "Hello World!";
	}
	if (langauge == 2) {	
		greetingString = "Hola Mundo!";
	}
	if (langauge == 3) {	
		greetingString = "Bonjour le Monde!";
	}	
	if (langauge >= 4) {
		greetingString = "###########";
	}
		//YOUR CODE IN HERE
		
		
		
		//Now, we'll print out the greeting...
		System.out.println(greetingString);
		
		myScanner.close();
	}
}
