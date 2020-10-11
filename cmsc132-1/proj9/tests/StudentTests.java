//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor 
//received any unauthorized 
//assistance on this assignment or examination
package tests;

import org.junit.*;

import wordFrequencyCounter.WordFrequencyCounter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author varanikasharma
 *Student Tests checking the functionality of the word frequency class
 */
public class StudentTests {
	//Testing addWordOccurrence
	@Test public void AddWordOccurence() {
	    WordFrequencyCounter wf= new WordFrequencyCounter();
	    String[] wo= {"Hello", "my", "name" , "is", "Java", "Hello", 
	    		"my", "name" , "is", "Java", "Hello", "my",
	    		"name" , "is", "Java"};

	   
	    for (String w : wo)
	      wf.addWordOccurrence(w);

	
	    assertEquals(42, wf.numWords());

	   
	    for (String word : wo)
	      assertEquals(1, wf.getOccurrences(word));


	    assertEquals(0, wf.getOccurrences("Hello"));
	  }

	  // Tests removeWordOccurrence(). 
	  
	  @Test public void removeWordOccurrence() {
	    WordFrequencyCounter wf= new WordFrequencyCounter();
	    String[] wo= {"Hello", "my", "name" , "is", "Java"};
	    String[] uW= {"hello", "my" , "name", "is", "java"};
	    int[] eO= {1, 1, 1, 1, 1};
	    int[] eO2= {0, 1, 2, 1, 2};
	    int i;

	 
	    for (String w : wo)
	      wf.addWordOccurrence(w);

	  
	    assertEquals(18, wf.numWords());


	    for (i= 0; i < uW.length; i++)
	      assertEquals(eO[i],
	                   wf.getOccurrences(uW[i]));

	   
	    wf.removeWordOccurrence("Hello");
	    wf.removeWordOccurrence("java");

	    
	    for (i= 0; i < uW.length; i++)
	      assertEquals(eO2[i],
	                   wf.getOccurrences(uW[i]));
	  }

	 //Test wordsWithOccurrences()
	  @Test public void wordsWithOccurrences() {
	    WordFrequencyCounter wf= new WordFrequencyCounter();
	    String[] w= {"Hello", "my", "name" , "is", "Java"};

	    
	    for (String wo : w)
	      wf.addWordOccurrence(wo);

	   
	    assertTrue(TestUtilities.compareCollection(wf.wordsWithOccurrences(1),
	                                               Arrays.asList("java")));
	    assertTrue(TestUtilities.compareCollection(wf.wordsWithOccurrences(1),
	                                               Arrays.asList("my")));
	    assertTrue(TestUtilities.compareCollection(wf.wordsWithOccurrences(1),
	                                               Arrays.asList("Hello")));
	    assertTrue(TestUtilities.compareCollection(wf.wordsWithOccurrences(1),
	                                               Arrays.asList("is")));
	 
	    assertTrue(TestUtilities.compareCollection(wf.wordsWithOccurrences(5),
	                                               new ArrayList<String>()));
	  }

	 //Test calling readWords to create one thread
	  @Test public void readWords1() {
	    WordFrequencyCounter wf= new WordFrequencyCounter();
	    String[] wo= {"Hello", "my", "name" , "is", "Java"};

	   
	    wf.readWords(Arrays.asList("public4-words"));

	    
	    assertEquals(5, wf.numWords());

	    
	    for (String word : wo)
	      assertEquals(1, wf.getOccurrences(word));
	  }

	  //Test calling readWords()
	  @Test public void readWords2() {
	    WordFrequencyCounter wfc= new WordFrequencyCounter();
	    String[] uniqueWords= {"a", "ab", "al", "an", "at", "b",
	                           "ba", "be", "bi", "br", "bre",
	                           "break", "bro", "but", "car",
	                           "ci", "c", "co", "cup", "cu",
	                           "de", "d", "do", "dr",
	                           "e", "f", "fi", "fin", "fo",
	                           "fr", "fru", "g", "ga", "ge",
	                           "go", "h", "ha", "he", "hel",
	                           "her", "hers", "hi", "ho", "hu", "i",
	                           "j", "ju", "l", "li", "m",
	                           "o", "ou", "ov", "p", "r", "re",
	                           "s", "se", "sh", "she", "si", "so",
	                           "som", "sp", "spr", "su", "t",
	                           "th", "the", "then", "ther", "to", "tot",
	                           "tr", "w", "wa", "wat", "we",
	                           "wh", "whe", "whi", "wi"};
	    int[] expectedOccurrences= {2, 0, 1, 5, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1,
	                                1, 1, 2, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1,
	                                1, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1,
	                                1, 1, 4, 1, 1, 1, 1, 1, 3, 1, 1, 2, 1, 1,
	                                1, 1, 1, 1, 1, 1, 3, 1, 1, 1, 1, 1, 10, 1,
	                                1, 26, 6, 1, 1, 1, 2, 3, 1, 1, 1, 3};
	    int i;


	    wfc.readWords(Arrays.asList("public5-words"));

	    
	    assertEquals(82, wfc.numWords());

	    
	    for (i= 0; i < uniqueWords.length; i++)
	      assertEquals(expectedOccurrences[i],
	                   wfc.getOccurrences(uniqueWords[i]));
	  }

}
