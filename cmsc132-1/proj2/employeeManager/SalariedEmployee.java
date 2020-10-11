//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor received any unauthorized 
//assistance on this assignment or examination
package employeeManager;

/**
 * @author varanikasharma This class is a subclass of Employee. This class
 *         contains methods to get the first name, last name, hours worked for
 *         the employee and how to get the paycheck amount for this employee
 */
public class SalariedEmployee extends Employee {
	//Initializing variables
	private String firstName = "";
	private String lastName = "";
	private double salary = 0.0;
	private int hoursWorked = 0;
	private int totalEmployees = 0;

	public SalariedEmployee(String firstName, String lastName, double salary) {
		//Creating a salaried employee object
		super(firstName, lastName, 0);
		this.salary = salary;
		this.hoursWorked = 0;
		totalEmployees++;

	}

	public String getFirstNameOfSalary() {
		//Returning the first name of the salaried employee
		return firstName;
	}

	public String getlastNameOfSalary() {
		//Returning the last name of the salaried employee
		return lastName;
	}

	public double getSalary() {
		//Return the salary of the employee
		return salary;
	}

	public int getTotalHoursWorked() {
		//Return the total hours worked for the salaried employee
		return hoursWorked;
	}

	public int WorkHoursForSalariedEmployee(int hoursAdded) {
		//Checking conditions to see if the work hours in total are greater
		//than 80. If this is true, then we return the hours worked. Else we 
		//will return the hoursWorked with the hoursAdded
		if (hoursWorked > 80 || hoursWorked + hoursAdded > 80) {
			return hoursWorked;
		}
		return hoursWorked + hoursAdded;
	}

	@Override
	public double getPayCheck() {
		//Return the salary for a salaried employee
		return salary / 26;

	}

	@Override
	public double getSales() {
		//Return the amount of sales for a salaried employee
		//This will always be 0.0 because we never have to keep track
		//of salaried employee's sales because they never make sales
		return 0.0;
	}
}