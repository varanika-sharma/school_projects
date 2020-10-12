package studentCode;
import java.util.Scanner;


public class CryptoQuiz {
	//NOTE: You MUST use these named constants.  The submit server will
	//      fail you on the Task 4 tests if you do not use these named
	//      constants in your code but rather use the actual values.
	static int NUM_BITS1 = 80, NUM_BITS2 = 128, NUM_BITS3 = 168;
	static String CRYPT1 = "Skipjack", CRYPT2 = "Rijndael", CRYPT3 = "TripleDES";



	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);


		//YOUR CODE IN HERE
		System.out.println("Enter 1 to guess a cryptographic system, 2 to guess how many BITs: ");
		int number;
		number = myScanner.nextInt();
		
		if (number == 1) {
			System.out.println("Choose number of BITs: ");
			int number_BITs;
			number_BITs = myScanner.nextInt();
			if (number_BITs == NUM_BITS1 || number_BITs == NUM_BITS2 || number_BITs == NUM_BITS3) {
				System.out.print("Which cryptographic system uses "+number_BITs + " BITs? ");
				String CryptoSystem;
				CryptoSystem = myScanner.next();
				if ((CryptoSystem.equals(CRYPT1) && number_BITs == NUM_BITS1) || CryptoSystem.equals(CRYPT2) && number_BITs == NUM_BITS2 || ((CryptoSystem.equals(CRYPT3) && number_BITs == NUM_BITS3))) { 
					System.out.println("Correct!");
				}
				else if (CryptoSystem != CRYPT1 && CryptoSystem != CRYPT2 && CryptoSystem != CRYPT3) {
					System.out.println("Incorrect!");
				}
			}
			else {
				System.out.println("Invalid choice.");
				
				 
				





			}

		}
		if (number == 2) {
			System.out.println("Choose a cryptographic system: ");
			String CryptoSystem2;
			CryptoSystem2 = myScanner.next();
	
			if (CryptoSystem2.equals(CRYPT1) || CryptoSystem2.equals(CRYPT2) || CryptoSystem2.equals(CRYPT3)) {
				System.out.println("How many BITs used in a "+ CryptoSystem2 + " system?"); 
				int number_BITs = myScanner.nextInt();
				
				if ((number_BITs == NUM_BITS1 && CryptoSystem2.equals(CRYPT1)) || (number_BITs == NUM_BITS2 && CryptoSystem2.equals(CRYPT2))|| (number_BITs == NUM_BITS3 && CryptoSystem2.equals(CRYPT3))) {
					System.out.println("Correct!"); }
				else {
					System.out.println("Incorrect!");}
			}
			else  {
				System.out.println("Invalid choice.");
				
				}

			
		myScanner.close();
		}
		

	}
}


	//YOUR CODE IN HERE		






