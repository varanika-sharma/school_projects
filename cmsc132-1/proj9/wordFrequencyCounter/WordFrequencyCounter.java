//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor 
//received any unauthorized 
//assistance on this assignment or examination
package wordFrequencyCounter;

import java.util.Set;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author varanikasharma This class has methods to manipulate a word frequency
 *         counter by adding word occurrences, removing said word occurrences,
 *         getting the number of occurrences of a certain word and going through
 *         files in order to read words and see how many instances of words are
 *         there and such. We are also able to manipulate those files and add
 *         more words to them or remove words from those files also
 */
public class WordFrequencyCounter {
	// Initializing variables
	HashMap<String, Integer> wordS = new HashMap<>();
	private int l = 0;
	private int occurence = 0;

	public void addWordOccurrence(String word) {
		// number of occurrences
		int o = 1;
		// null check
		if (word == null) {
			throw new IllegalArgumentException();
		}
		// Handling an empty string
		if (!word.equals("")) {

			// if there is an upper case letter set word equal to word's 
			//lower case
			// version
			if (UpperCaseChecker(word) == false) {
				word = word.toLowerCase();
			}
			// if trailing punctuation exist
			word = endingPunc(word);

			// if the wordMap already contains word then get occurrences. 
			//increase
			// occurrences by one and update word
			if (wordS.containsKey(word)) {
				o = wordS.get(word);
				o++;
				wordS.replace(word, o);
			}
			// add word to the wordMap
			wordS.put(word, o);

		}
	}

	public boolean UpperCaseChecker(String word) {
		return word.equals(word.toLowerCase());
	}

	public int numWords() {
		// returning the number of words in the wordSet
		if (wordS.size() == 0)
			return 0;
		return wordS.size();
	}

	public int getOccurrences(String word) {
		// Returning the number of occurrences of the parameter word
		// that is found in the word Set
		if (word == null) {
			throw new IllegalArgumentException();
		}
		if (!wordS.containsKey(word)) {
			return 0;
		}
		return wordS.get(word);
	}

	public boolean removeWordOccurrence(String word) {
		// First, I check if word is null. If it is, then I throw a Illegal
		// Argument Exception. Then I check if the Word Set contains the word
		// and if it does not then I set t to false. Else, I subtract 1 from 
		//the
		// amount of occurrences of word in the Word Set and I put that back 
		//into
		// the Word Set, and set t to true. I then return t.
		boolean t = false;

		if (word == null) {
			throw new IllegalArgumentException();
		}
		if (!wordS.containsKey(word)) {
			t = false;
		} else {
			int nOccur = getOccurrences(word) - 1;
			wordS.put(word, nOccur);
			t = true;
		}
		return t;
	}

	public Set<String> wordsWithOccurrences(int occurrences) {
		// Create a new HashSet and check if wordSet is empty or if
		// occurrences are equal to 0 or negative. If they are, we
		// return an empty set. Then, we go through the the keys in
		// the wordSet and see if the occurences of p equal the
		// occurences parameter. If they do, then we return x
		HashSet<String> x = new HashSet<String>();
		if (wordS.isEmpty()) {
			return x;
		} else if (occurrences == 0 || occurrences < 0) {
			return x;
		}
		for (String p : wordS.keySet()) {
			if (wordS.get(p) == occurrences) {
				x.add(p);
			}
		}
		return x;
	}

	public void readWords(List<String> fileNames) {
		// We first create a ArrayList of threads. We then create
		// Threads and add them to the ArrayList. We start all the
		// threads and then join them. We also make sure to
		// catch any interrupted Exceptions
		List<Thread> threadList = new ArrayList<Thread>();
		if (fileNames.size() != 0) {
			for (String nameOfFiles : fileNames) {
				threadList.add(new Thread(new MyThread(nameOfFiles)));
			}
		}
		for (Thread thread : threadList) {
			thread.start();
		}
		for (Thread t : threadList) {
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private String endingPunc(String word) {
		// Replacing trailing punctuation
		String onlyWord = word.replaceAll("[^a-zA-Z]+$", "");
		return onlyWord;
	}

	class MyThread implements Runnable {
		// Initializing variables
		String threadName = "";

		// Constructor
		public MyThread(String threadName) {
			this.threadName = threadName;
		}

		@Override
		public void run() {
			// We read the files and spilt each of the strings. We then
			// add the separate words into the bufferedReader class.
			// We also catch the File not Foujd exception and the IO Exception
			try {
				File file = new File(threadName);
				BufferedReader bufferedReader = 
						new BufferedReader(new FileReader(file));
				String s;
				while ((s = bufferedReader.readLine()) != null) {
					for (String fileReader : s.split("\\s+")) {
						synchronized (wordS) {
							addWordOccurrence(fileReader);
						}
					}
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
