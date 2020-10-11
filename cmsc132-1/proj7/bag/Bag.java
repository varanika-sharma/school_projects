//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor received
//any unauthorized 
//assistance on this assignment or examination
package bag;

import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @author varanikasharma This class has methods in order to manipulate the bag
 *         that we created. I created a HashMap to store the data in the bag and
 *         then created methods such as checking if the HashMap contained the
 *         value that we wanted to find etc.
 */
public class Bag {
	// Initializing variables
	private int size = 0;
	private Map<Integer, Integer> bag = new HashMap<>();

	public void add(int elt) {
		// First we initialize an integer with the position of elt.
		// Then we check if the bag contains elt. If it does not, then
		// we put elt at the first position. Else we put elt at the end
		// and increase the position of elt. We then increase the size
		Integer kS = bag.get(elt);
		if (!(bag.containsKey(elt))) {
			bag.put(elt, 1);
		} else {
			bag.put(elt, ++kS);
		}
		size++;

	}

	public boolean contains(int elt) {
		// We create a boolean value and check if the bag does not contain elt.
		//If
		// it does not, then we return false. If it does, however, we return 
		//true.
		// We return the boolean that we created at the end
		boolean Bag = false;
		if (!bag.containsKey(elt)) {
			return false;
		} else if (bag.containsKey(elt)) {
			Bag = true;
		}
		return Bag;

	}

	public int getCount(int elt) {
		// We check if the bag contains elt, then we return 0. Else, we return
		// the position of elt
		if (!bag.containsKey(elt)) {
			return 0;
		}
		return bag.get(elt);
	}

	public int size() {
		// We create an array of objects and transfer the values of bag to the
		// array. We also initialize an integer p and set it equal to 0. We then
		// loop through the length of the array and add the Integer
		// representation
		// of the object i to p. We then return p at the end
		Object[] theArray;
		theArray = bag.values().toArray();
		int p = 0;

		for (int i = 0; i < theArray.length; i++) {
			p += (Integer) theArray[i];
		}

		return p;
	}

	public Set<Integer> uniqueElements() {
		// We create a new HashSet of type Integer. We then go through the
		// keySet
		// of the bag and add each of the key sets to the new HashSet that we
		// created. We then return the HashSet at the end
		Set<Integer> uE = new HashSet<>();
		for (Integer i : bag.keySet()) {
			uE.add(i);
		}
		return uE;
	}

	public void remove(int elt) {
		// We create an integer that stores the position of the elt. Then, we
		// check if the bag contains the elt and if the position of the elt in
		// the bag is greater than 0. We then have an inner if statement that
		// checks if greater than or equal to 2, we put elt and subtract the
		// position f the bag. At this point, we also decrease the size of the
		// set. Else, we remove the elt from the bag and decrease the size
		Integer kS = bag.get(elt);
		if (bag.containsKey(elt) && bag.get(elt) > 0) {
			if (kS >= 2) {
				bag.put(elt, --kS);
				size--;
			} else {
				bag.remove(elt);
				size--;
			}

		}
	}
}
