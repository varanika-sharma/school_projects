package tests;

import org.junit.*;

import bag.Bag;
import courseList.CourseList;

import static org.junit.Assert.*;

public class StudentTests {

  /* Remove this comment and write your student tests in this class.
   *
   * Note that your student tests must be your OWN WORK.  Copying the public
   * tests and turning them in as your student tests (with minimal or no
   * changes) would be plagiarism, and sharing student tests, or working
   * together to write them, is prohibited.
   */
	 @Test public void testPublic1() {
		    Bag bag= new Bag();

		    bag.add(131);
		    bag.add(132);
		    bag.add(250);

		    assertTrue(bag.contains(131));
		    assertTrue(bag.contains(132));
		    assertFalse(bag.contains(130));
		  }

		  // Tests calling size() on a small bag with a few elements, having only
		  // one occurrence of each element.
		  @Test public void testPublic2() {
		    Bag bag= new Bag();

		    bag.add(131);
		    bag.add(132);

		    assertEquals(2, bag.size());
		  }

		  // Tests calling size() on a small bag with a few elements, having more
		  // than one occurrence of one element.
		  @Test public void testPublic3() {
		    Bag bag= new Bag();

		    bag.add(131);
		    bag.add(132);
		    bag.add(132);

		    assertTrue(bag.contains(131));
		    assertTrue(bag.contains(132));
		    assertFalse(bag.contains(130));

		    assertEquals(3, bag.size());
		  }

		  // Tests calling getCount() on a small bag with a few elements, where one
		  // element has one occurrence and one has than one occurrence.
		  @Test public void testPublic4() {
		    Bag bag= new Bag();

		    bag.add(131);
		    bag.add(132);
		    bag.add(132);

		    assertEquals(1, bag.getCount(131));
		    assertEquals(2, bag.getCount(132));
		  }

		  @Test public void testPublic17() {
			    CourseList courseList= new CourseList();

			    assertEquals(0, courseList.numEnrolled("CMSC 123"));
			  }

			  // Tests calling numCoursesTaking() on students taking courses in a
			  // CourseList that contains several students.
			  @Test public void testPublic18() {
			    CourseList courseList= exampleCourseList();

			    assertEquals(4, courseList.numCoursesTaking("Armand Armadillo"));
			    assertEquals(3, courseList.numCoursesTaking("Ginny Giraffe"));
			    assertEquals(3, courseList.numCoursesTaking("Wally Walrus"));
			    assertEquals(4, courseList.numCoursesTaking("Peggy Penguin"));
			  }

			  // Tests calling numCoursesTaking() on a student who is not taking any
			  // courses in a CourseList.
			  @Test public void testPublic19() {
			    CourseList courseList= exampleCourseList();

			    assertEquals(0, courseList.numCoursesTaking("Otto Otter"));
			  }

			  // Tests calling numEnrolled() on an unpopular course that no students are
			  // taking (obviously not one that is taught by Larry Herman....).
			  @Test public void testPublic20() {
			    CourseList courseList= exampleCourseList();

			    assertEquals(0, courseList.numEnrolled("CMSC 123"));
			  }

			  // Tests calling numEnrolled() on all courses that are being taken by at
			  // least one student.
			  @Test public void testPublic21() {
			    CourseList courseList= exampleCourseList();

			    assertEquals(2, courseList.numEnrolled("CMSC 456"));
			    assertEquals(4, courseList.numEnrolled("CMSC 567"));
			    assertEquals(1, courseList.numEnrolled("CMSC 700"));
			    assertEquals(3, courseList.numEnrolled("CMSC 799"));
			    assertEquals(1, courseList.numEnrolled("CMSC 800"));
			    assertEquals(2, courseList.numEnrolled("CMSC 899"));
			    assertEquals(1, courseList.numEnrolled("MATH 345"));
			  }

			  // Tests that takeCourse() does not add a student to a course more than
			  // once.
			  @Test public void testPublic22() {
			    CourseList courseList= new CourseList();

			    courseList.takeCourse("Ellie Elephant", "CMSC 799");
			    courseList.takeCourse("Armand Armadillo", "CMSC 799");
			    courseList.takeCourse("Ellie Elephant", "CMSC 799");

			    assertEquals(1, courseList.numCoursesTaking("Ellie Elephant"));
			    assertEquals(2, courseList.numEnrolled("CMSC 799"));
			  }
			  public CourseList exampleCourseList() {
				    CourseList courseList= new CourseList();

				    courseList.takeCourse("P A", "CMSC 799");
				    courseList.takeCourse("A A", "CMSC 899");
				    courseList.takeCourse("P P", "CMSC 456");
				    courseList.takeCourse("W W", "MATH 345");
				    courseList.takeCourse("W W", "CMSC 567");
				    courseList.takeCourse("G G", "CMSC 456");
				    courseList.takeCourse("A A", "CMSC 567");
				    courseList.takeCourse("P P", "CMSC 567");
				    courseList.takeCourse("A A", "CMSC 700");
				    courseList.takeCourse("A A", "CMSC 800");
				    courseList.takeCourse("G G", "CMSC 567");
				    courseList.takeCourse("P P", "CMSC 799");
				    courseList.takeCourse("W W", "CMSC 799");
				    courseList.takeCourse("P P", "CMSC 899");

				    return courseList;
				  }
		 
}
