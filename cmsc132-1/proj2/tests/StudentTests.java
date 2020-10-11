package tests;

import org.junit.*;

import employeeManager.Company;
import employeeManager.Manager;

import static org.junit.Assert.*;

public class StudentTests {

  /* Remove this comment and write your student tests in this class.
   *
   * Note that your student tests must be your OWN WORK.  Copying the public
   * tests and turning them in as your student tests (with minimal or no
   * changes) would be plagiarism, and sharing student tests, or working
   * together to write them, is prohibited.
   */
	@Test
	public void CreatingAccounts() {
	    Company company1= Manager.createAccount("P");
	    Company company2= Manager.createAccount("R", 10);

	    assertEquals("P", company1.getCompanyName());
	    assertEquals("R", company2.getCompanyName());
	  }
	 @Test 
	 public void testingWorkHours() {
		    Company company= TestData.exampleCompany4();

		    assertTrue(company.workHours("H", "P", 15));
		    assertTrue(company.workHours("H", "P", 13));
		    assertTrue(company.workHours("H", "P", 10));
		    assertTrue(company.workHours("H", "P", 156));
		    assertTrue(company.workHours("G", "N", 120));
		    assertTrue(company.workHours("G", "N", 15));
		    assertTrue(company.workHours("G", "N", 6));
		    assertTrue(company.workHours("R", "X", 8));

		    assertEquals(33, company.numHours("H", "P"));
		    assertEquals(0, company.numHours("Freddy", "Frog"));
		    assertEquals(30, company.numHours("G", "N"));
		    assertEquals(0, company.numHours("Kourtney", "Koala"));
		    assertEquals(8, company.numHours("R", "X"));
		    assertEquals(0, company.numHours("Bruce", "Moose"));
		  }
	 @Test 
	 public void testCommissionedEmployees() {
		    Company company= TestData.exampleCompany4();

		    assertFalse(company.workHours("A", "B", 1));
		    assertFalse(company.makeSale("C", "D", 1000.0));
		  }
	 @Test public void testingBillAmount() {
		    Company company1= Manager.createAccount("S", 5);
		    Company company2= TestData.exampleCompany1();

		    assertEquals(5.0, company1.billAmount(), 5.001);
		    assertEquals(5.0, company2.billAmount(), 5.001);
		  }
	 @Test public void testPublic15() {
		    Company company= TestData.exampleCompany1();

		    assertEquals(7, company.getPayroll(), 4.9);

		  }
}
