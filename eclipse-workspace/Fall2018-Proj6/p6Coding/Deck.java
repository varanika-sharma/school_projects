package p6Coding;

import java.util.ArrayList;

public class Deck {

	//You need to use this ArrayList<Card> structure to hold the deck
	//  
	//Your cannot use regular arrays in this class other than in the
	//  deal method, which needs to return an array
	private ArrayList<Card> cards;
	private int currCard;
	public static final int NumCards = 45;
	

	public Deck() {
		 ArrayList<Card>deckCards = new ArrayList<Card>(NumCards);
	}

	public Deck(Deck other) {
		throw new RuntimeException("You need to implement this...");
	}

	public Card getCardAt(int position) {
		throw new RuntimeException("You need to implement this...");
	}

	public int getNumCards() {
		throw new RuntimeException("You need to implement this...");
	}


	public Card[] deal(int numCards) {
		throw new RuntimeException("You need to implement this...");
	}


	public void cut(int position) throws StarDeckException {
		throw new RuntimeException("You need to implement this...");
	}
	
	
	
	
	public void shuffle() {
		throw new RuntimeException("Challenge problem...");
	}
	

}
