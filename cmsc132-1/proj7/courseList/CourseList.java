//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor received
//any unauthorized 
//assistance on this assignment or examination
package courseList;

import java.util.Map;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;

/**
 * @author varanikasharma This map is a simulation of the taking courses and
 *         checking whether certain courses are being taken. We have methods to
 *         check whether the course is being taken or to actually take the
 *         course. We can also check how many courses students are taking. We
 *         can also check what the most popluar course is among other things
 */
public class CourseList {
	// Initializing variables
	private Map<String, Set<String>> st;
	private int nC;

	public CourseList() {
		// Constructor that also initializes the variables
		st = new HashMap<>();
		nC = 0;
	}

	public void takeCourse(String student, String course) throws 
	IllegalArgumentException {
		// First, we check if the student is null or if the course is null. If
		//it
		// is then we throw an IllegalArgumentException. Else , we check if the
		// students HashMap that we created above contains the student 
		//parameter.
		// If it does not, then we put the student in the st HashMap. We then
		// create another Set with an parameter of String and set it equal to
		// student parameter initialized in the method. We then add the course
		// to the student's own courses and increase the size of the number
		// of courses integer that we have keep tracking of the number of 
		//courses
		// that the student is currently taking
		if (student == null || course == null) {
			throw new IllegalArgumentException();
		} else if (!st.containsKey(student)) {
			st.put(student, new HashSet<>());
		}
		Set<String> coursesS = st.get(student);
		coursesS.add(course);
		nC++;
	}

	public boolean isTakingCourse(String student, String course) 
			throws IllegalArgumentException {
		// First, we check if the student is null or if the course is null. If
		//it
		// is then we throw an IllegalArgumentException. Then we check if the
		// students HashMap that we created above contains the student parameter
		// and also check if the students HashMap contains the course parameter.
		// If both of those are true, then we return true, else we return false
		if (student == null || course == null) {
			throw new IllegalArgumentException();
		}
		if (st.containsKey(student) && st.get(student).contains(course)) {
			return true;
		}
		return false;
	}

	public int numCoursesTaking(String student)
			throws IllegalArgumentException {
		// If the student parameter is null, then we return a Illegal Argument
		// Exception. Else if the students HashMap does not contain the student
		// parameter then we return 0. If it does, then we return the size of 
		// the
		// courses HashMap
		if (student == null) {
			throw new IllegalArgumentException();
		} else if (!st.containsKey(student)) {
			return 0;
		} else {
			return st.get(student).size();
		}
	}

	public int numEnrolled(String course) throws IllegalArgumentException {
		// If the course parameter is null, then we throw an Illegal Argument
		// Exception. We then create a total course integer that will keep count
		// of the amount of courses that the student is enrolled in. We then go
		// through ther keySet of the students and for the student s, we check 
		//if
		// the courses that they take contain the course parameter. If it does,
		// then we increment the number of courses that the student is enrolled
		// in. We then return tC at the end
		if (course == null) {
			throw new IllegalArgumentException();
		}
		int tC = 0;
		for (String s : st.keySet()) {
			if (st.get(s).contains(course)) {
				tC++;
			}
		}
		return tC;
	}

	public String mostPopularCourse() {
		// We create a new HashMap. We then go through the keySet of the 
		//students
		// HashMap and create a new Set with a String parameter and get the
		// position of the student from the students HashMap. We then go through
		// the new HashMap that we just created and create a new integer that
		// gets the default between the String and 0 and puts the String at the
		// position of the next available space. Next, we create a new ArrayList
		// and sort it. We then compare the value of both maps, and return a
		// String value.
		Map<String, Integer> Cc = new HashMap<>();
		for (String student : st.keySet()) {
			Set<String> courses = st.get(student);
			for (String co : courses) {
				int c = Cc.getOrDefault(co, 0);
				Cc.put(co, (c + 1));
			}
		}
		List<Map.Entry<String, Integer>> sortedList =
				new ArrayList<>(Cc.entrySet());
		Collections.sort(sortedList,
				new Comparator<Map.Entry<String, Integer>>() {
			@Override
			public int compare(Map.Entry<String, Integer> o1,
					Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});
		return sortedList.size() > 0 ? sortedList.get(0).getKey() : null;

	}

	public boolean dropCourse(String student, String course) 
			throws IllegalArgumentException {
		// If the student or the course is null we throw an Illegal Argument
		// Exception. If the students HashMap contains the student and
		// the student's courses have the course parameter, then we get the
		// student and remove that course from their own courses. We then return
		// true if that process is properly done. If not, then we return false.
		if (student == null || course == null) {
			throw new IllegalArgumentException();
		}
		if (st.containsKey(student) && st.get(student).contains(course)) {
			st.get(student).remove(course);
			return true;
		}
		return false;
	}

}