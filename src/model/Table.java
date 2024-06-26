package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * represents a table of randomized cards, containing the specified 
 * number of pairs of cards all within the specified category
 */
public class Table {
	
	private String category;
	private int numOfPairs;
	private Mode mode;
	// layout of cards in a random order
	private Card[] randomizedCards;
	
	/**
	 * creates a table with x pairs of cards in the given category in 
	 * a randomized order
	 * 
	 * @param category
	 * @param numOfPairs
	 */
	public Table(Mode mode, String category, int numOfPairs) {
		this.category = category;
		this.numOfPairs = numOfPairs;
		this.mode = mode;
		if (mode == Mode.NORMAL || mode == Mode.TIMED || mode == Mode.LIMITED) {
			randomizedCards = new Card[numOfPairs*2];
		} else if (mode == mode.EASY || mode == Mode.MATCH4) {
			randomizedCards = new Card[numOfPairs*4];
		}
		randomizeCards();
	}
	
	private void randomizeCards() {
		CardSet cardSet = new CardSet(category);
		ArrayList<Card> allCards = cardSet.getCards();
		// copying allCards
		ArrayList<Card> tempCards = new ArrayList<>();
		for (Card card : allCards) {
			tempCards.add(card);
		}
		Collections.shuffle(tempCards);
		// if normal or timed mode adds 2 of each random card to the randomizedCards 
		// array
		// if match 4 mode adds 4 of each random card to the randomCards array
		for (int i = 0; i < numOfPairs; i++) {
			Card card = tempCards.get(i);
			if (mode == Mode.NORMAL || mode == Mode.TIMED || mode == Mode.LIMITED) {
				randomizedCards[i*2] = new Card(card.getName(), card.getFileName());
				randomizedCards[i*2+1] = new Card(card.getName(), card.getFileName());
			} else if (mode == Mode.EASY || mode == Mode.MATCH4){
				randomizedCards[i*4] = new Card(card.getName(), card.getFileName());
				randomizedCards[i*4+1] = new Card(card.getName(), card.getFileName());
				randomizedCards[i*4+2] = new Card(card.getName(), card.getFileName());
				randomizedCards[i*4+3] = new Card(card.getName(), card.getFileName());
			}
		}
		// shuffle randomizedCards array
	    Random random = new Random();
	    for (int i = randomizedCards.length - 1; i > 0; i--) {
	        int index = random.nextInt(i + 1);
	        Card temp = randomizedCards[index];
	        randomizedCards[index] = randomizedCards[i];
	        randomizedCards[i] = temp;
	    }
	}
	
	/**
	 * gets the array of cards
	 * 
	 * @return the array of cards which are in a random order
	 */
	public Card[] getRandomizedCards() {
		return randomizedCards;
	}
	
	/**
	 * gets the card at the given index
	 * 
	 * @param index  the index of the array of the card to get
	 * @return the card at the given index
	 */
	public Card getCard(int index) {
		return randomizedCards[index];
	}
	
	/**
	 * gets the name of the category
	 * 
	 * @return the name of the category
	 */
	public String getCategory() {
		return category;
	}
	
	/**
	 * gets the number of pairs of cards
	 * 
	 * @return the number of pairs of cards on the table
	 */
	public int getNumOfPairs() {
		return numOfPairs;
	}

}
