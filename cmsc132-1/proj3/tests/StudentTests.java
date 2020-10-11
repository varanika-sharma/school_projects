package tests;

import org.junit.*;

import linkedStr.LinkedStr;

import static org.junit.Assert.*;

public class StudentTests {
		//A test creating a new Linked List Object that is 
		//empty
	  @Test public void NewLinkedList() {
		    LinkedStr newS= new LinkedStr();

		    assertEquals(0, newS.length());
		  }
	  //A test checking the append method by appending certain 
	  //characters in order to create a new word
	  @Test public void Append() {
		    LinkedStr myStr= new LinkedStr();

		    myStr= myStr.append('c').append('r').append('e').append('a')
		    		.append('m').append('s');

		    assertEquals("creams", TestUtilities.toString(myStr));
		    assertEquals(6, myStr.length());
		  }
	  @Test public void DeleteChars() {
		  //A test that deletes the characters at certain positions
		    LinkedStr myStr= new LinkedStr();

		    myStr.insert(0, 'p');
		    myStr.insert(1, 'l');
		    myStr.insert(2, 'a');
		    myStr.insert(3, 'i');
		    myStr.insert(4, 'n');

		    myStr.deleteCharsAt(1, 1);
		    myStr.deleteCharsAt(2, 1);

		    assertEquals("pin", TestUtilities.toString(myStr));
		  }
	  @Test public void MethodsonAnEmptyList() {
		  //This test calls the methods on an empty list
		    LinkedStr myStr= new LinkedStr();
		    LinkedStr myStr2= new LinkedStr();

		    assertNull(myStr.getCharAt(3));
		    assertEquals(-1, myStr.findFirst(0, 'p'));
		    assertEquals(0, myStr.compareTo(myStr2));
		  }
	  @Test public void Insert() {
		  //This test inserts characters into specific positions 
		  //in the list
		    LinkedStr myStr= new LinkedStr();
		    LinkedStr myStr2;

		    myStr.insert(0, 'p');
		    myStr.insert(1, 'i');
		    myStr.insert(2, 'n');
		    myStr.insert(4, 's');

		    myStr2= new LinkedStr(myStr);

		    myStr2.insert(2, 'r');
		    assertEquals("pins", TestUtilities.toString(myStr));
		    assertEquals("pirns", TestUtilities.toString(myStr2));
		  }
	  
}
