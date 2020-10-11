//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor received any unauthorized 
//assistance on this assignment or examination
package employeeManager;

/**
 * @author varanikasharma This Commissioned Employee class extends the Employee
 *         class that is mentioned below This class has different methods to
 *         return the first name, last name, the amount of sales for a
 *         commissioned employee and get the amount of money that a 
 *         commissioned employee will make
 */
public class CommissionedEmployee extends Employee {
	private String firstName = "";
	private String lastName = "";
	private double comissionRate = 0.0;
	private int totalEmployees = 0;
	private int salesMade = 0;
	private int salesAmt = 0;

	public CommissionedEmployee(String firstName, String lastName,
			double comissionRate, int salesMade) {
		//Creating a commissioned employee object
		super(firstName, lastName, 0);
		this.comissionRate = comissionRate;
		totalEmployees++;

	}

	public String getComissionedFirstName() {
		//A method to return the first name
		return firstName;
	}

	public String getComissionedlastName() {
		//A method to return the last name
		return lastName;
	}

	public int getSalesAmt() {
		//Returning the sales made by the commissioned employee
		return salesMade;
	}

	@Override
	public void setSalesAmt(double salesMade) {
		//A method to set the sales amount
		//An overrided method
		this.salesMade += salesMade;
		System.out.println(salesMade);
	}

	@Override
	public double getPayCheck() {
		//Returning the amount of salary for a commissioned employee.
		//An overrided method
		System.out.println(comissionRate);
		System.out.print(salesMade);
		return (comissionRate / 100) * salesMade;
	}

}
