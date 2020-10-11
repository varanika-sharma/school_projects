//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor received any unauthorized 
//assistance on this assignment or examination
package employeeManager;

/**
 * @author varanikasharma This class creates an Employee object. It has methods
 *         that allow it to return the first name, the last name, and the number
 *         of hours that the employees have worked. This class also has a
 *         ToString method that works to make sure that an Employee will be
 *         categorized in the correct manner. This class is the superclass to
 *         the CommissionedEmployee and the SalariedEmployee class
 */
public class Employee {
	//Instantiating all the variables
	private String fN = "";
	private String lN = "";
	private int hoursWorked = 0;
	private boolean commissionedEmployee;

	private double salary;
	private double commissionRate;
	private int salesAmt = 0;

	private int hoursAdded;
	private boolean validHours;

	public Employee(String firstName, String lastName, double s) {
		//An constructor to create a generic employee object
		this.fN = firstName;
		this.lN = lastName;

	}

	public String getFirstName() {
		//A method to return the first name
		return fN;
	}

	public String getLastName() {
		//A method to return the last name
		return lN;
	}

	public int getHoursWorked() {
		//A method to return the number of hours worked by the employee
		return hoursWorked;

	}

	public boolean validHours() {
		//A method to check if the hours worked are valid or not
		return true;

	}

	public void setHoursWorked(int hours) {
		//A method to set the number of hours worked by the employee
		this.hoursWorked = hours;
	}

	public double getSales() {
		//A method that returns the sales that an employee made
		return salesAmt;
	}

	public void setSalesAmt(double salesMade) {
		//A method that sets the sales amount for an employee
		salesAmt += salesMade;

	}

	public double getPayCheck() {
		//A method to get the salary for the employee
		//This method is overriden in both the salaried and
		//commissioned employee class
		return 0.0;
	}

	public String toString() {
		//A method that returns the characteristics of an employee
		String format = fN + " " + lN;
		return format;

	}

}