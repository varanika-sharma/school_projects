//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor received any unauthorized 
//assistance on this assignment or examination
package quuly;

public class Quuly {
	// initializing variables
	private final Students studentDb;

	private StudentNameQueue studentQueue;

	public Quuly(int maxVisits) {
		// checking if the maxVisits for each of the students is greater than 1.
		// Then a new student object is created and it is added into the studentQueue
		// object
		// was already created before
		if (maxVisits < 1) {
			maxVisits = 1;
		}
		studentDb = new Students();
		studentQueue = new StudentNameQueue(maxVisits);
	}

	public boolean addStudent(String studentName, Integer studentId) {
		// The method is checking whether both the studentName and studentID are valid.
		// This method is also checking whether the student object that I created at the
		// beginning
		// does not contain the studentID. If all of these conditions are correct, then
		// the student object that is created adds a new student object that has the
		// studentName
		// and studentId parameter passed in. Then we return true, else we return false
		if (isValidName(studentName) && istheIDValid(studentId) && !studentDb.containsStudentWithId(studentId)) {
			studentDb.addStudent(new Student(studentName, studentId));
			return true;
		} else {
			return false;
		}

	}

	private boolean isValidName(String studentName) {
		// A private helper method that checks if the studetName that is being passed in
		// is
		// valid or not. We will first check if the studentName is null or if the length
		// of the
		// student's Name is greater than 1. If it is, then the method will return
		// false. If
		// it is not then the method will return true
		if (studentName == null || studentName.length() < 1) {
			return false;
		}

		return true;
	}

	private boolean istheIDValid(Integer studentId) {
		// A private helper method that checks whether the id that is being passed in is
		// valid or not
		// The conditions check whether the id is null or greater than 1. if it is then
		// the method
		// returns false. If it isn't then, the method returns true
		if (studentId == null || studentId < 1) {
			return false;
		}
		return true;
	}

	public int numStudents() {
		// A method that returns the number of students in the list
		return studentDb.total();
	}

	public boolean addStudentToQueue(Integer id) {
		// This method first checks whether the ID is not valid. If that is true, then
		// the if statement
		// returns false. Else, a new student object is created with the same id, and
		// then an if
		// statement is checked with the conditions being if the student object does not
		// equal null and if the queue that holds the student objects can add this new
		// student object
		// that is being created and it returns true. Else the method will just return
		// false
		if (!istheIDValid(id)) {
			return false;
		}
		Student student = studentDb.findStudentWithId(id);
		if (student != null && studentQueue.canBeAdded(student)) {
			studentQueue.addVisit(student);
			return true;
		}
		return false;
	}

	public int queueSize() {
		// This method returns the integer value of the number of students that are
		// in the queue
		return studentQueue.waitingStudentsCount();
	}

	public boolean isInQueue(Integer id) {
		// This method checks if the student is in the queue or not.
		// First, there is an if statement that checks if the id that
		// is being passed in is equal to null. If it is then, we return false.
		// If it isn't then we create a new student object with that same id and then
		// check
		// if that new student is in the queue already. If that student is already in
		// the
		// queue, then the method will return false. Else, we return true
		if (id == null) {
			return false;
		}
		Student student = studentDb.findStudentWithId(id);
		if (student == null) {
			return false;
		}
		return studentQueue.isAlreadyScheduledForAVisit(student);
	}

	public int isInQueue(String name) {
		// We check if a student with the same name is in the queue already.
		// We add this into one of the private helper methods that is created
		return studentQueue.waitingInQueueWithSameName(name);
	}

	public boolean helpNextStudent() {
		// We call a private helper method on the student queue.
		return studentQueue.nextStudent();
	}

	public int numStudentsHelped() {
		// We call a private helper method that calls the total number of visits on each
		// of
		// the student objects
		return studentQueue.totalVisits();
	}

	public int numTimesHelped(Integer id) {
		// This method checks the number of times that the students in the queue have
		// been helped.
		// We create a new student object and try to go through the student queue and
		// find a student
		// with the same id. We then check if the student object is null or not. If it
		// is then we return
		// -1. Else, we call the private helper method getTotalVisitsPerStudent on the
		// student object
		Student student = studentDb.findStudentWithId(id);
		if (student == null) {
			return -1;
		}
		return studentQueue.getTotalVisitsOfTheStudent(student);
	}

	public boolean dropStudent(Integer id) {
		// We check if the id that is being passed in is null. If it is, then we return
		// false.
		// We create a new student object and try to find a student with the same id in
		// the queue
		// that we created above. We check if the student object that we created is null
		// and if it is
		// then we return false. Else, we remove the student object from the student
		// queue and
		// the student object queue and we return true.
		if (id == null) {
			return false;
		}
		Student s = studentDb.findStudentWithId(id);
		if (s == null) {
			return false;
		}
		studentDb.remove(s);
		studentQueue.remove(s);
		return true;
	}

}
