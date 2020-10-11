//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor received any unauthorized 
//assistance on this assignment or examination
package employeeManager;

/**
 * @author varanikasharma This class has a String name and a double billAmt. We
 *         use both of these parameters to create different accounts for both
 *         paid and free companies. For the paid companies we only need to have
 *         a name, but for the free companies we need to have a maximum number
 *         of employees that we cannot go over
 * 
 */
public class Manager {

	public static String name;
	public static double billAmt;

	// create the manager class which creates a free account and a 
	// paid account for the company

	public static Company createAccount(String name) {
		// Paid Account
		if (name == null || name.isEmpty()) {
			return null;
		}
		Company madeAccount = new Company(name, -1, billAmt);

		return madeAccount;
	}

	
	public static Company createAccount(String name, int maxEmployees) {
		// Free Account
		Company freeAccount = new Company(name, maxEmployees, billAmt);
		if (freeAccount.eC.length > maxEmployees || name == null || 
				maxEmployees <= 0) {
			return null;
		}
		return freeAccount;
	}

}
