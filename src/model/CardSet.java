package model;

import java.util.ArrayList;
import java.util.Collections;

/**
 * represents a set of all cards in a specified category
 */
public class CardSet {

	private String category;
	private ArrayList<Card> cards;

	/**
	 * creates a card set by adding all the cards in the given category to an
	 * ArrayList
	 * 
	 * @param category the name of the category to get the cards from
	 */
	public CardSet(String category) {
		this.category = category;
		cards = new ArrayList<>();
		if (category.equals("cacti")) {
			setCactiCards();
		} else if (category.equals("cities")) {
			setCitiesCards();
		} else if (category.equals("mammals")) {
			setMammalsCards();
		} else if (category.equals("mountains")) {
			setMountainsCards();
		} else if (category.equals("reptiles")) {
			setReptilesCards();
		}
	}

	private void setCactiCards() {
		String basePath = "file:src/images/cards/cacti/";
		addCard("Apache Hedgehog Cactus", basePath + "cacti_apachehedgehogcactus.png");
		addCard("Barrel Cactus", basePath + "cacti_barrelcactus.png");
		addCard("Jumping Cholla", basePath + "cacti_jumpingcholla.png");
		addCard("Organ Cactus", basePath + "cacti_organcactus.png");
		addCard("Pincushion Cactus", basePath + "cacti_pincushioncactus.png");
		addCard("Prickly Pear", basePath + "cacti_pricklypear.png");
		addCard("Saguaro", basePath + "cacti_saguaro.png");
		addCard("Teddy Bear Cholla", basePath + "cacti_teddybearcholla.png");
	}

	private void setCitiesCards() {
		String basePath = "file:src/images/cards/cities/";
		addCard("Bisbee", basePath + "cities_bisbee.png");
		addCard("Flagstaff", basePath + "cities_flagstaff.png");
		addCard("Jerome", basePath + "cities_jerome.png");
		addCard("Pheonix", basePath + "cities_phoenix.png");
		addCard("Scottsdale", basePath + "cities_scottsdale.png");
		addCard("Sedona", basePath + "cities_sedona.png");
		addCard("Tombstone", basePath + "cities_tombstone.png");
		addCard("Tucson", basePath + "cities_tucson.png");
	}

	private void setMammalsCards() {
		String basePath = "file:src/images/cards/mammals/";
		addCard("Antelope Jackrabbit", basePath + "mammals_antelopejackrabbit.png");
		addCard("Black Bear", basePath + "mammals_blackbear.png");
		addCard("Coyote", basePath + "mammals_coyote.png");
		addCard("Javelina", basePath + "mammals_javelina.png");
		addCard("Lesser Long-nosed Bat", basePath + "mammals_lesserlongnosedbat.png");
		addCard("Mountain Lion", basePath + "mammals_mountainlion.png");
		addCard("Mule Deer", basePath + "mammals_muledeer.png");
		addCard("white-nosed Coati", basePath + "mammals_whitenosedcoati.png");
	}

	private void setMountainsCards() {
		String basePath = "file:src/images/cards/mountains/";
		addCard("A Mountain", basePath + "mountains_amountain.png");
		addCard("Mt Lemmon", basePath + "mountains_mtlemmon.png");
		addCard("Quinlan Mountains", basePath + "mountains_quinlanmountains.png");
		addCard("Rincon Mountains", basePath + "mountains_rinconmountains.png");
		addCard("Santa Catalina Mountains", basePath + "mountains_santacatalinamountains.png");
		addCard("Santa Rita Mountains", basePath + "mountains_santaritamountains.png");
		addCard("Tortolita Mountains", basePath + "mountains_tortolitamountains.png");
		addCard("Tucson Mountains", basePath + "mountains_tucsonmountains.png");
	}

	private void setReptilesCards() {
		String basePath = "file:src/images/cards/reptiles/";
		addCard("Desert Iguana", basePath + "reptiles_desertiguana.png");
		addCard("Gila Monster", basePath + "reptiles_gilamonster.png");
		addCard("Greater Short-horned Lizard", basePath + "reptiles_greatershorthornedlizard.png");
		addCard("Ornate Tree Lizard", basePath + "reptiles_ornatetreelizard.png");
		addCard("Regal Horned Lizard", basePath + "reptiles_regalhornedlizard.png");
		addCard("Sidewinder", basePath + "reptiles_sidewinder.png");
		addCard("Sonoran Collared Lizard", basePath + "reptiles_sonorancollaredlizard.png");
		addCard("Western Diamondback Rattlesnake", basePath + "reptiles_westerndiamondbackrattlesnake.png");
	}

	/**
	 * gets the list of cards
	 * 
	 * @return an ArrayList of all the cards in the given category
	 */
	public ArrayList<Card> getCards() {
		return cards;
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
	 * Used to add a new card to the card set
	 * 
	 * @param name     The card's name
	 * @param fileName The card's file path
	 */
	public void addCard(String name, String fileName) {
		cards.add(new Card(name, fileName));
	}
}