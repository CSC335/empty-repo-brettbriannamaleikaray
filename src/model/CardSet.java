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
	 * creates a card set by adding all the cards in the given
	 * category to an ArrayList
	 * 
	 * @param category  the name of the category to get the cards from
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
		cards.add(new Card("Apache Hedgehog Cactus", basePath + "cacti_apachehedgehogcactus.png"));
		cards.add(new Card("Barrel Cactus", basePath + "cacti_barrelcactus.png"));
		cards.add(new Card("Jumping Cholla", basePath + "cacti_jumpingcholla.png"));
		cards.add(new Card("Organ Cactus", basePath + "cacti_organcactus.png"));
		cards.add(new Card("Pincushion Cactus", basePath + "cacti_pincushioncactus.png"));
		cards.add(new Card("Prickly Pear", basePath + "cacti_pricklypear.png"));
		cards.add(new Card("Saguaro", basePath + "cacti_saguaro.png"));
		cards.add(new Card("Teddy Bear Cholla", basePath + "cacti_teddybearcholla.png"));
	}
	
	private void setCitiesCards() {
		String basePath = "file:src/images/cards/cities/";
		cards.add(new Card("Bisbee", basePath + "cities_bisbee.png"));
		cards.add(new Card("Flagstaff", basePath + "cities_flagstaff.png"));
		cards.add(new Card("Jerome", basePath + "cities_jerome.png"));
		cards.add(new Card("Pheonix", basePath + "cities_phoenix.png"));
		cards.add(new Card("Scottsdale", basePath + "cities_scottsdale.png"));
		cards.add(new Card("Sedona", basePath + "cities_sedona.png"));
		cards.add(new Card("Tombstone", basePath + "cities_tombstone.png"));
		cards.add(new Card("Tucson", basePath + "cities_tucson.png"));
	}
	
	private void setMammalsCards() {
		String basePath = "file:src/images/cards/mammals/";
		cards.add(new Card("Antelope Jackrabbit", basePath + "mammals_antelopejackrabbit.png"));
		cards.add(new Card("Black Bear", basePath + "mammals_blackbear.png"));
		cards.add(new Card("Coyote", basePath + "mammals_coyote.png"));
		cards.add(new Card("Javelina", basePath + "mammals_javelina.png"));
		cards.add(new Card("Lesser Long-nosed Bat", basePath + "mammals_lesserlongnosedbat.png"));
		cards.add(new Card("Mountain Lion", basePath + "mammals_mountainlion.png"));
		cards.add(new Card("Mule Deer", basePath + "mammals_muledeer.png"));
		cards.add(new Card("white-nosed Coati", basePath + "mammals_whitenosedcoati.png"));
	}
	
	private void setMountainsCards() {
		String basePath = "file:src/images/cards/mountains/";
		cards.add(new Card("A Mountain", basePath + "mountains_amountain.png"));
		cards.add(new Card("Mt Lemmon", basePath + "mountains_mtlemmon.png"));
		cards.add(new Card("Quinlan Mountains", basePath + "mountains_quinlanmountains.png"));
		cards.add(new Card("Rincon Mountains", basePath + "mountains_rinconmountains.png"));
		cards.add(new Card("Santa Catalina Mountains", basePath + "mountains_santacatalinamountains.png"));
		cards.add(new Card("Santa Rita Mountains", basePath + "mountains_santaritamountains.png"));
		cards.add(new Card("Tortolita Mountains", basePath + "mountains_tortolitamountains.png"));
		cards.add(new Card("Tucson Mountains", basePath + "mountains_tucsonmountains.png"));
	}
	
	private void setReptilesCards() {
		String basePath = "file:src/images/cards/reptiles/";
		cards.add(new Card("Desert Iguana", basePath + "reptiles_desertiguana.png"));
		cards.add(new Card("Gila Monster", basePath + "reptiles_gilamonster.png"));
		cards.add(new Card("Greater Short-horned Lizard", basePath + "reptiles_greatershorthornedlizard.png"));
		cards.add(new Card("Ornate Tree Lizard", basePath + "reptiles_ornatetreelizard.png"));
		cards.add(new Card("Regal Horned Lizard", basePath + "reptiles_regalhornedlizard.png"));
		cards.add(new Card("Sidewinder", basePath + "reptiles_sidewinder.png"));
		cards.add(new Card("Sonoran Collared Lizard", basePath + "reptiles_sonorancollaredlizard.png"));
		cards.add(new Card("Western Diamondback Rattlesnake", basePath + "reptiles_westerndiamondbackrattlesnake.png"));
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
}