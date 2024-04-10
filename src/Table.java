import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Table {
	
	private String category;
	private int numOfPairs;
	// layout of cards in a random order
	private Card[] randomizedCards;
	
	public Table(String category, int numOfPairs) {
		this.category = category;
		this.numOfPairs = numOfPairs;
		randomizedCards = new Card[numOfPairs*2];
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
		// adds 2 of each random card to the randomizedCards array
		for (int i = 0; i < numOfPairs; i++) {
			randomizedCards[i*2] = tempCards.get(i);
			randomizedCards[i*2+1] = tempCards.get(i);
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
	
	public Card[] getRandomizedCards() {
		return randomizedCards;
	}
	
	public Card getCard(int index) {
		return randomizedCards[index];
	}
	
	public String getCategory() {
		return category;
	}
	
	public int getNumOfPairs() {
		return numOfPairs;
	}

}
