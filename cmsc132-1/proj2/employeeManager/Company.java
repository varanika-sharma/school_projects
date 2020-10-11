//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor received any unauthorized 
//assistance on this assignment or examination

package employeeManager;

//import java.util.Arrays;

/**
 * @author varanikasharma This is a Company class. It has to deal with
 *         manipulating a Company object that was created in the Manager class,
 *         which is located in the same class. This current Company class has
 *         many different methods which allow for adding two different kinds of
 *         employees (salaried and commissioned). This class also allows the
 *         user to get employee names and see how much the employer needs to pay
 *         each of their employees during a pay period. This class also allows
 *         for employers to record how many sales a employee has made in a pay
 *         period.
 *
 */
public class Company {
//Initializing variables for the company object
	Employee[] eC;
	private int totalEmployeesInCompany;
	private String companyName;
	private boolean paid;
	private String[] employeeNames;
	private int maxEmployees;
	private boolean salariedEmployee;
	private boolean commissionedEmployee;
	private int numberOfSales;
	private int commissionRate;
	private double salary;
	private String firstName;
	private String lastName;
	int numSales;
	int hrs;
	int numEmployees;
	private boolean free;

	public Company(String cN) {
		//A constructor that creates a paid company object
		this.companyName = cN;
		paid = true;

	}

	public Company(String companyName, int maxEmployees, double billAmt) {
		// A constructor for the free company object
		this.companyName = companyName;
		eC = new Employee[0];
		employeeNames = new String[0];
		this.maxEmployees = maxEmployees;
		free = true;
	}

	public String getCompanyName() {
		// returns the name of the current company object
		return this.companyName;
	}

	public boolean hireCommissionedEmployee(String firstName, String lastName,
			double commissionRate) {
		// First we have an if statement to check if the firstName, the 
		//lastName parameters are null or if those parameters are left empty.
		//If these conditions are all met, then we return false.
		// Else, if the commission rate is not greater than 0.0 but less than 
		//100.0 then we also return false. If paid is false, and of the
		//maxEmployees parameter is not equal to -1 and the EmployeesInCompany
		//length +1 is less than the current number of maxEmployees then we
		//also return false. We go through the array of employees and check 
		//if both the first and last name equal the parameter that is passed in
		//then the method also returns false. If not, we create a new
		// Commissioned employee object and then add it to the employee array
		if (firstName == null || lastName == null || firstName.isEmpty() 
				|| lastName.isEmpty())
			return false;

		if (commissionRate < 0.0 || commissionRate > 100.0)
			return false;
		if (paid == false) {
			if (maxEmployees != -1 && eC.length + 1 > this.maxEmployees)
				return false;
		}

		for (int x = 0; x < eC.length; x++)
			if (eC[x].getFirstName().equals(firstName) && 
					eC[x].getLastName().equals(lastName))
				return false;

		CommissionedEmployee c = new CommissionedEmployee(firstName, lastName, 
				commissionRate, numSales);
		Employee[] employeesAdded = new Employee[eC.length + 1];

		for (int y = 0; y < eC.length; y++)
			employeesAdded[y] = eC[y];

		employeesAdded[eC.length] = c;

		eC = employeesAdded;
		numEmployees++;
		commissionedEmployee = true;

		return true;
	}

	public boolean hireSalariedEmployee(String firstName, String lastName,
			double yearlySalary) {
		// First we have an if statement to check if the firstName, the
		//lastName parameters are null or if those parameters are left empty.
		//If these conditions are all met, then we return false.
		// Else, if the commission rate is not greater than 0.0 but less
		//than 100.0 then we also return false. If paid is false, 
		//and of the maxEmployees parameter is not equal to -1 and
		// the EmployeesInCompany length +1 is less than the current number of
		// maxEmployees then we also return false. We go through the array of
		//employees and check if both the first and last name equal
		// the parameter that is passed in then the method also returns 
		//false. If not, we create a new Salaried employee object and then 
		//add it to the employee array
		if (firstName == null || lastName == null || firstName.isEmpty() || 
				lastName.isEmpty())
			return false;

		if (yearlySalary <= 0.0)
			return false;
		if (paid == false) {
			if (maxEmployees != -1 && eC.length + 1 > maxEmployees)
				return false;
		}

		for (int x = 0; x < eC.length; x++)
			if (eC[x].getFirstName().equals(firstName) && 
					eC[x].getLastName().equals(lastName))
				return false;

		SalariedEmployee s = new SalariedEmployee(firstName, lastName,
				yearlySalary);

		Employee[] employeesAdded = new Employee[eC.length + 1];

		for (int y = 0; y < eC.length; y++)
			employeesAdded[y] = eC[y];

		employeesAdded[eC.length] = s;

		eC = employeesAdded;
		numEmployees++;
		salariedEmployee = true;

		return true;

	}

	public int numEmployees() {
		// return the total number of Employees
		return numEmployees;
	}

	public int employeeCapacity() {
		// if the boolean value of paid is true, then we return the max
		//value. However if it is free then we just return the max
		//number of Employees
		if (paid == true) {
			return Integer.MAX_VALUE;
		}
		return this.maxEmployees;
	}

	public String[] getEmployeeNames() {
		// Return the string array containing both the first and last names of 
		//the employees who work in the company
		String[] eNames = new String[eC.length];
		if (eC.length == 0)
			return new String[0];

		for (int i = 0; i < eC.length; i++) {
			eNames[i] = eC[i].toString();
		}

		for (int y = 0; y < eC.length; y++) {
			for (int x = 0; x < eC.length; x++) {

				String tempVar;
				if (eNames[y].compareTo(eNames[x]) < 0) {
					tempVar = eNames[y];
					eNames[y] = eNames[x];
					eNames[x] = tempVar;
				}
			}
		}

		return eNames;
	}

	public boolean workHours(String firstName, String lastName, int numHours) {
		// Return the number of work hours that an employee has incurred
		boolean wH = true;
		boolean exit = false;
		if (firstName == null || lastName == null || firstName.isEmpty()
				|| lastName.isEmpty()) {
			wH = false;
		}
		if (numHours <= 0) {
			wH = false;
		}
		if (wH == true) {
			for (int i = 0; i < eC.length && exit == false; i++) {

				if (eC[i].getFirstName().equals(firstName) &&
						eC[i].getLastName().equals(lastName)) {
					if (salariedEmployee && eC[i].getHoursWorked() +
							numHours <= 80) {
						eC[i].setHoursWorked(eC[i].getHoursWorked() +
								numHours);
						exit = true;

					}

				}

			}
		}
		if (exit == false) {
			return exit;
		} else {
			return wH;
		}

	}

	public int numHours(String firstName, String lastName) {
		// This method returns the number of hours that a specific 
		//employee has worked
		if (firstName == null || lastName == null || firstName.isEmpty() || 
				lastName.isEmpty()) {
			return -1;
		} else {
			for (int i = 0; i < eC.length; i++) {
				if ((eC[i].getFirstName().equals(firstName) &&
						eC[i].getLastName().equals(lastName))) {
					return eC[i].getHoursWorked();
				}

			}

		}
		return -1;
	}

	public boolean makeSale(String firstName, String lastName, double saleAmt) {
		//This method returns true if the particular employee makes a sale
		if (firstName == null || lastName == null || firstName.isEmpty() ||
				lastName.isEmpty()) {
			return false;

		} else if (saleAmt <= 0) {
			return false;
		} else {
			for (int i = 0; i < eC.length; i++) {
				if ((eC[i].getFirstName().equals(firstName) && 
						eC[i].getLastName().equals(lastName))) {

					eC[i].setSalesAmt(saleAmt);
					return true;
				}
			}

		}
		return false;
	}

	public double amtSalesMade(String firstName, String lastName) {
		// if the firstName or lastName parameter is null or is Empty 
		//then we return -1.0. Else if we have a salaried employee we 
		//return 0.0.
		// Else we go through the employees array and check if the first
		//and last name
		// at that particular index equals the first and last name that
		//is being passed in as a parameter. If that condition is true then
		//we return the amount of sales for that particular employee

		if (firstName == null || lastName == null || firstName.isEmpty() ||
				lastName.isEmpty()) {
			return -1.0;
		} else {
			for (int i = 0; i < eC.length; i++) {
				if ((eC[i].getFirstName().equals(firstName) && 
						eC[i].getLastName().equals(lastName))) {
					return eC[i].getSales();
				}
			}
		}
		return -1.0;

	}

	public double getPaycheckAmount(String firstName, String lastName) {
		//We have to first check if the firstName is null or the lastName is 
		//null or if the first name is empty or the last name is empty.
		//If these conditions are all met, then we return -1. Else we go
		//through the employees array and see if we have an employee whose
		// last name equals their first name. If that is true, we then get 
		//their paycheck amount

		if (firstName == null || lastName == null ||
				firstName.isEmpty() || lastName.isEmpty()) {
			return -1.0;
		} else {
			for (int j = 0; j < eC.length; j++) {
				if (eC[j].getFirstName().equals(firstName) && 
						eC[j].getLastName().equals(lastName)) {
					return eC[j].getPayCheck();
				}

			}
		}
		return -1.0;
	}

	// if (firstName == null || lastName == null || firstName.isEmpty() ||
	// lastName.isEmpty()
//        		|| !(eC[i].getFirstName().equals(firstName))
	//&& eC[i].getLastName().equals(lastName)) {
//            return -1.0;
//        }
//    else {
//            for (int j = 0; j < eC.length; j++) {
//                if ((eC[j].getFirstName().equals(firstName)
//                        && eC[j].getLastName().equals(lastName))) {
//                    return eC[j].getPayCheck();
//                }
//
//            }
//            return -1.0;
//
//        }
//    	}
//		return -1.0;

	public double getPayroll() {
		// Returning the payroll for each of the types of employee
		double pR = 0.0;
		for (int i = 0; i < eC.length; i++) {
			pR += eC[i].getPayCheck();
		}
		return pR;
	}

	public void newPayPeriod() {
		// Setting the hours and the number of sales equal to 0
		hrs = 0;
		numSales = 0;
	}

	public double billAmount() {
		// If paid is true then we return 10 times the number of employees in 
		//the company.
		// If free is true, then we return 0.0
		if (eC.length >= this.maxEmployees) {
			return 10.0 * numEmployees;
		} else {
			return 0.0;
		}

	}
}