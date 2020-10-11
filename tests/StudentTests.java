package tests;

import org.junit.*;

import quuly.Quuly;

import static org.junit.Assert.*;

public class StudentTests {
	
 @Test
 public void  AddedToQuuly(){
	 Quuly t = new Quuly(5);
	 t.addStudent("One", 1);
	 t.addStudent("Two", 2);
	 t.addStudent("Three", 3);
	 t.addStudent("Four", 4);
	 t.addStudent("Five", 5);
	 t.addStudent("Six", 6);
	 
	 assertEquals(6,t.numStudents());
 }
 	@Test 
 	public void AddedToQueueNullCheck() {
 		 Quuly testQuuly = new Quuly(5);
 		testQuuly.addStudent("One", 1);
 		 testQuuly.addStudent("Two", 2);
 		 testQuuly.addStudent("Three", 3);
 		 testQuuly.addStudent("Four", 14);
 		 testQuuly.addStudent("Five", 5);
 		 testQuuly.addStudentToQueue(null);
 		
 		 
 		 assertEquals(false,testQuuly.addStudentToQueue(null));
 	}
 	@Test
 	public void AddedToQueueIDNOTFOUND() {
		 Quuly testQuuly = new Quuly(5);
		 testQuuly.addStudent("One", 1);
		 testQuuly.addStudent("Two", 2);
		 testQuuly.addStudent("Three", 3);
		 testQuuly.addStudent("Four", 14);
		 testQuuly.addStudent("Five", 5);
		 testQuuly.addStudentToQueue(1245);
		
		 
		 assertEquals(false,testQuuly.addStudentToQueue(1245));
		 assertEquals(0, testQuuly.queueSize());
}
 	@Test
 	public void AddedToQueueIdalreadyinQueue() {
		 Quuly testQuuly = new Quuly(5);
		 testQuuly.addStudent("One", 1);
		 testQuuly.addStudent("Two", 2);
		 testQuuly.addStudent("Three", 3);
		 testQuuly.addStudent("Four", 14);
		 testQuuly.addStudent("Five", 5);
		 
		 testQuuly.addStudentToQueue(12345);
		 testQuuly.addStudentToQueue(12345);
		
		 
		 assertEquals(false,testQuuly.addStudentToQueue(12345));
		 assertEquals(1, testQuuly.queueSize());
}
 	@Test
 	public void AddedToQueueIdNotInQueue() {
		 Quuly testQuuly = new Quuly(5);
		 testQuuly.addStudent("One", 1);
		 testQuuly.addStudent("Two", 2);
		 testQuuly.addStudent("Three", 3);
		 testQuuly.addStudent("Four", 14);
		 testQuuly.addStudent("Five", 5);
		 
		 testQuuly.addStudentToQueue(12345);
		 testQuuly.addStudentToQueue(12346);
		
		 
		 assertEquals(true,testQuuly.addStudentToQueue(12345));
		 assertEquals(true,testQuuly.addStudentToQueue(12346));
		 assertEquals(2, testQuuly.queueSize());
}
 	@Test
 	public void AddToQueue() {
 		Quuly testQuuly = new Quuly(5);
 	testQuuly.addStudent("One", 1);
	 testQuuly.addStudent("Two", 2);
	 testQuuly.addStudent("Three", 3);
	 testQuuly.addStudent("Four", 14);
	 testQuuly.addStudent("Five", 5);
	 testQuuly.helpNextStudent();
	 assertEquals(1, testQuuly.numStudentsHelped());
	 
}
 	@Test
 	public void NumTimesHelpedPerStudent() {
 		Quuly testQuuly = new Quuly(5);
 	testQuuly.addStudent("One", 1);
	 testQuuly.addStudent("Two", 2);
	 testQuuly.addStudent("Three", 3);
	 testQuuly.addStudent("Four", 14);
	 testQuuly.addStudent("Five", 5);
	 testQuuly.dropStudent(1);
	 assertEquals(1, testQuuly.dropStudent(1));
}
}
