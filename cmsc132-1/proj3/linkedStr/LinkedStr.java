//Name: Varanika Sharma
//UID: 115851306
//Directory ID: vsharma2
//Discussion Section: 0204
//Honor Pledge: I pledge on my honor that I have not given nor received any 
//unauthorized 
//assistance on this assignment or examination
package linkedStr;

import java.lang.IndexOutOfBoundsException;

/**
 * @author varanikasharma This class will modify a current Linked List object
 *  by
 *         appending and creating new Linked List objects and appending
 *         different characters to the current Linked List object. An inner
 *         class is also created that helps creates Nodes so that we can use
 *         them in the creation of new Linked List objects
 */
public class LinkedStr implements Comparable<LinkedStr> {
	// An inner class that creates nodes
	class Node {
		private char data;
		private Node next;

		public Node(char d) {
			// A constructor for the node inner class
			this.data = d;
			this.next = null;
		}

		public String toString() {
			// A toString that some of the methods use
			return "" + data;
		}
		// private Node Node(char position) {
		// Node p = new Node(position);
		// return p;
		// }
	}

//Initialing some Node variables
	Node head;
	Node tail;
	int size;

	public LinkedStr() {
		// A constructor for creating a new Linked List
		head = null;
		tail = null;
		size = 0;
	}

	public LinkedStr(LinkedStr otherStr) {
		// A deep copy constructor that copies the contents of
		// one Linked list to another linked list object
		this();
		Copy(otherStr);
	}

	private void Copy(LinkedStr l) {
		// A helper method that is called in the method above
		if (l.length() == 0) {
			return;
		}
		Node c = l.head;
		while (c != null) {
			this.append(c.data);
			c = c.next;

		}
	}

	public LinkedStr append(char ch) {
		// A method that appends the parameter ch to
		// the end of the current linked list object
		Node p = new Node(ch);
		if (head == null) {
			head = p;
			tail = p;

		} else {
			tail.next = p;
			tail = p;

		}
		size++;
		return this;
	}

	public int length() {
		// returning the length of the size
		return size;
	}

	public Character getCharAt(int position) {
		// A method that returns the character at the position
		// that is being passed into the method
		Node c = head;
		if (position < 0 || position > this.length()) {
			return null;
		}
		for (int i = 0; i < position; i++) {
			c = c.next;
		}
		return (char) c.data;
	}

	public void reset() {
		// Resetting the Linked List object
		head = null;
		tail = null;
		size = 0;
	}

	public void insert(int position, char ch) throws
	IndexOutOfBoundsException {
		// Inserting a character at the position that is being
		// passed in
		Node n = new Node(ch);
		if (position < 0 || position > this.length()) {
			throw new IndexOutOfBoundsException();
		} else if (this.length() == position) {
			this.append(ch);
		} else {
			Node c = head;
			Node p = null;
			for (int i = 0; i < position && c != null; i++) {
				p = c;
				c = c.next;

			}
			n.next = c;
			if (p == null) {
				head = n;
			} else {
				p.next = n;
			}
			size++;
		}

	}

//private Node Node(int position) {
//	 Node p = new Node(position);
	// return p;
	// }

	public void concat(LinkedStr otherStr) {
		// This method concatenates another Linked List to the
		// current Linked List object
		if (otherStr == null) {
			size = this.length();
		} else {
			for (int i = 0; i < otherStr.length(); i++) {
				this.append(otherStr.getCharAt(i));
			}

		}

	}

	public int findFirst(int position, char ch) {
		// This method retrieves the first position of
		// the first occurrence of the character that is
		// being passed in as a parameter
		int i = 0;
		Node curr = head;
		while (curr != null) {
			if (i >= position && curr.data == ch) {
				return i;
			}
			i++;
			curr = curr.next;
		}
		return -1;
	}

	public void deleteCharsAt(int position, int numChars) throws
	IndexOutOfBoundsException {
		// This method delete the number of characters at a
		// particular position in the current linked list
		if (position > this.length()) {
			throw new IndexOutOfBoundsException();
		}
		if (numChars < 1) {
			size = this.length();
		}
		if (head == null) {
			return;
		}
		Node temp = head;
		if (position == 0) {
			head = temp.next;
			return;
		}
		for (int i = 0; temp != null && i < position - 1; i++) {
			temp = temp.next;
		}
		int j = 0;
		while (j < numChars) {
			if (temp == null || temp.next == null) {
				return;
			}
			Node next = temp.next.next;
			temp.next = next;
			size--;
			j++;
		}
	}

	public int compareTo(LinkedStr otherStr) {
		// This method compares the characters of a specific
		// linked list
		for (int i = 0; i < otherStr.length(); i++) {
			if (this.getCharAt(i).equals(otherStr.getCharAt(i))) {
				return 0;
			} else if ((this.getCharAt(i) < otherStr.getCharAt(i))) {
				return -1;
			} else if ((this.getCharAt(i)) > otherStr.getCharAt(i)) {
				return 1;
			} else if (this.getCharAt(i).equals(otherStr.getCharAt(i)) &&
					otherStr.length() > this.length()) {
				return -1;
			} else if (this.getCharAt(i).equals(otherStr.getCharAt(i)) &&
					otherStr.length() < this.length()) {
				return 1;
			} else if (otherStr == null) {
				return -1;
			}
		}
		return 0;

	}
}
