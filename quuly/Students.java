//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor received any unauthorized 
//assistance on this assignment or examination
package quuly;

import java.util.ArrayList;
import java.util.List;

public class Students {
	// Initializing the variables
	private List<Student> studentList;

	public Students() {
		// Creatong a new arrayList
		studentList = new ArrayList<>();
	}

	public boolean containsStudentWithId(Integer studentId) {
		// Calling the findStudentWithId method and checking if it is null or not. It
		// returns either true of false depending on what is being passed in
		return findStudentWithId(studentId) != null;
	}

	public void addStudent(Student student) {
		// Adding a student to the List that was just created
		studentList.add(student);
	}

	public int total() {
		// Returning the size of the studentList
		return studentList.size();
	}

	public Student findStudentWithId(Integer id) {
		// This method goes through each student object in the studentList and checks if
		// the
		// ids are the same for each student object's id versus the id that was passed
		// in.
		// Then the method returns the student object and null
		for (Student student : studentList) {
			if (student.isTheSame(id)) {
				return student;
			}
		}
		return null;
	}

	public Student findStudentWithName(String name) {
		// This method goes through the studentList and finds the students with the same
		// name.
		// The method returns null
		for (Student student : studentList) {

		}
		return null;
	}

	public void remove(Student student) {
		// This method goes thruogh the studentList and checks if the ids are the same
		// for the studentList objects and the id that is being passed in.
		// If it is, then the studentList removes that student
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).isTheSame(student.getID())) {
				studentList.remove(student);
				// break;
			}
		}
	}
}
