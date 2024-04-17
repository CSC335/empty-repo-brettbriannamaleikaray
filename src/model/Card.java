package model;

/**
 * represents a card and contains the name of the card and the file name
 * of the card image
 */
public class Card {
	
	private String name;
	private String fileName;
	
	/**
	 * creates a card with the given name and file name
	 * 
	 * @param name  the name of the card
	 * @param fileName  the file name where the card image is located
	 */
	public Card(String name, String fileName) {
		this.name = name;
		this.fileName = fileName;
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
	
}