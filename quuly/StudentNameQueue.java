package quuly;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentNameQueue {
//Initialization of variables
    private final List<Student> queue;
    private final List<Student> totalVisits;

    private final int maxVisitsAllowed;

    public StudentNameQueue(int maxVisits) {
    	//A constructor that is initializing the various variables that we have created
        this.maxVisitsAllowed = maxVisits;
        this.queue = new ArrayList<>();
        this.totalVisits = new ArrayList<>();
    }

    public boolean canBeAdded(Student student) {
    	//A method that checks whether the student can be added into the method.
    	//First, the method creates a studentInQueue object and calls a method to 
    	//find the student in the queue. If the student is in the queue then we return false
    	// and then we have another if statement to check if the total visits for the student object
    	//is equal to the maximum number of visits allowed, then we return false. After the method
    	//we return true
        Student studentInQueue = findStudentInQueue(student);
        if (studentInQueue != null) {
            return false;
        }
        if (totalVisitsForStudent(student) == maxVisitsAllowed) {
            return false;
        }
        return true;
    }

    private int totalVisitsForStudent(Student student) {
    	//A private helper method that counts the number of visits that each student has. We start out with
    	//a total variable that initialize it to 0. Then we go through each item in the total visits list and
    	//check if the student is the same as the studentVisited object and increase the total if it is.
    	//Then we return the total
        int total = 0;
        for (Student studentVisited : totalVisits) {
            if (studentVisited.isTheSame(student.getID())) {
                total++;
            }
        }
        return total;
    }

    public void addVisit(Student student) {
    	//We add the student to the queue object we created above
        queue.add(student);
    }

    public boolean isAlreadyScheduledForAVisit(Student student) {
    	//A method that returns true if the student is not in the queue
        Student studentInQueue = findStudentInQueue(student);
        return studentInQueue != null;
    }

    public Student findStudentInQueue(Student student) {
    	//A method that checks if the student is in the queue. It does this by
    	//getting the id of each student object and checking if it is same as the id of the student
    	//object that is  being passed in. The method then return the student object and return null
        for (Student studentInQueue : queue) {
            if (studentInQueue.isTheSame(student.getID())) {
                return studentInQueue;
            }
        }
        return null;
    }

    public int waitingStudentsCount() {
    	//This method returns the size of the queue
        return queue.size();
    }

    public int waitingInQueueWithSameName(String name) {
    	//This method checks if the the name parameter being passed in is null or the length is greater than 1
    	//If it is, then return 0. We create a total variable that we equal to 0 and then go through
    	//each student in the queue object and check if the names are the same. If they are, then
    	//the total increases. We return the total variable at the end of the method
        if (name == null || name.length() < 1) {
            return 0;
        }
        int total = 0;
        for (Student studentInQueue : queue) {
            if (name.equals(studentInQueue.getName())) {
                total++;
            }
        }
        return total;
    }

    public boolean nextStudent() {
    	//This method checks if there are any students in the line so that we can remove them
    	//and start the process of helping the ne4xt student. We create an iterator and check if it
    	//has another name. If it does, we remove the name and increase the number of visits for that
    	//student. We return true
        Iterator<Student> iterator = queue.iterator();
        if (iterator.hasNext()) {
            Student student = iterator.next();
            iterator.remove();
            totalVisits.add(student);
            return true;
        }
        return false;
    }

    public int totalVisits() {
//We return the size of the total visits list
        return totalVisits.size();
    }

    public int getTotalVisitsOfTheStudent(Student student) {
    	//This method gets the total visits of each of the students. We create a total variable and
    	//go through each of the student objects in the totalVisits lists. We check if the ids are the same
    	//for each of the student object and the students in the queue. We then increase the total variable
    	//and at the end of the method, we return the total variable
        int total = 0;
        for (Student studentInQueue : totalVisits) {
            if (studentInQueue.isTheSame(student.getID())) {
                total++;
            }
        }
        return total;
    }

    public void remove(Student student) {
    	//This method goes through the queue and checks if each of the items are the same
    	//as the ids of the student object that is being created in the method signature
    	//We then remove the student from the queue
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).isTheSame(student.getID())) {
                queue.remove(student);
                //break;
            }
        }
    }
}
