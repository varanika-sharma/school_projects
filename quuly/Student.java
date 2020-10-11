//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor received any unauthorized 
//assistance on this assignment or examination
package quuly;

public class Student {
	// Initializing variables
	String name;
	int id;

	public Student(String studentName, Integer studentId) {
		// Creating a constructor and initializing variables
		this.name = studentName;
		this.id = studentId;
	}

	public int getID() {
		// returning the id
		return id;
	}

	public boolean isTheSame(int iD) {
		// Check if the id is the same as an ID object that is bring passed in
		if (this.id == iD) {
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		// returning the name
		return name;
	}

}
