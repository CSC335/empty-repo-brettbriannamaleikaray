package model;

/**
 * represents a card and contains the name of the card and the file name of the
 * card image
 */
public class Card {

	private String name;
	private String fileName;
	private boolean flipped;
	private boolean destroyed;

	/**
	 * creates a card with the given name and file name
	 * 
	 * @param name     the name of the card
	 * @param fileName the file name where the card image is located
	 */
	public Card(String name, String fileName) {
		this.name = name;
		this.fileName = fileName;
	}

	/**
	 * Lets us know if if the card is flipped face up or not
	 * 
	 * @return A boolean. "True" means card is flipped face up, "False" means it's
	 *         face down
	 */
	public boolean isFlipped() {
		return flipped;
	}

	/**
	 * Lets us know if if the card has been removed from the board
	 * 
	 * @return A boolean. "True" means card has been removed from the board
	 */
	public boolean isDestroyed() {
		return destroyed;
	}

	/**
	 * Changes the card's 'destroyed' status (meaning it's been removed from the
	 * board) to true
	 */
	public void destroyCard() {
		destroyed = true;
	}

	/**
	 * gets the card name
	 * 
	 * @return the the name of the card
	 */
	public String getName() {
		return name;
	}

	/**
	 * gets the file name
	 * 
	 * @return the file name where the card image is located
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * Changes the card's flipped flag (which indicates whether the card is flipped)
	 * to the opposite value
	 */
	public void flipCard() {
		if (flipped == true)
			flipped = false;
		else
			flipped = true;
	}
}