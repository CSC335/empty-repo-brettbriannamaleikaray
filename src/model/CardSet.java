package model;
import java.util.ArrayList;
import java.util.Collections;

public class CardSet {
	
	private String category;
	private ArrayList<Card> cards;
	
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
		cards.add(new Card("apache hedgehog cactus", basePath + "cacti_apachehedgehogcactus.png"));
		cards.add(new Card("barrel cactus", basePath + "cacti_barrelcactus.png"));
		cards.add(new Card("jumping cholla", basePath + "cacti_jumpingcholla.png"));
		cards.add(new Card("organ cactus", basePath + "cacti_organcactus.png"));
		cards.add(new Card("pincushion cactus", basePath + "cacti_pincushioncactus.png"));
		cards.add(new Card("prickly pear", basePath + "cacti_pricklypear.png"));
		cards.add(new Card("saguaro", basePath + "cacti_saguaro.png"));
		cards.add(new Card("teddy bear cholla", basePath + "cacti_teddybearcholla.png"));
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
		cards.add(new Card("antelope jackrabbit", basePath + "mammals_antelopejackrabbit.png"));
		cards.add(new Card("black bear", basePath + "mammals_blackbear.png"));
		cards.add(new Card("coyote", basePath + "mammals_coyote.png"));
		cards.add(new Card("javelina", basePath + "mammals_javelina.png"));
		cards.add(new Card("lesser long-nosed bat", basePath + "mammals_lesserlongnosedbat.png"));
		cards.add(new Card("mountain lion", basePath + "mammals_mountainlion.png"));
		cards.add(new Card("mule deer", basePath + "mammals_muledeer.png"));
		cards.add(new Card("white-nosed coati", basePath + "mammals_whitenosedcoati.png"));
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
		cards.add(new Card("desert iguana", basePath + "reptiles_desertiguana.png"));
		cards.add(new Card("gila monster", basePath + "reptiles_gilamonster.png"));
		cards.add(new Card("greater short-horned lizard", basePath + "reptiles_greatershorthornedlizard.png"));
		cards.add(new Card("ornate tree lizard", basePath + "reptiles_ornatetreelizard.png"));
		cards.add(new Card("regal horned lizard", basePath + "reptiles_regalhornedlizard.png"));
		cards.add(new Card("sidewinder", basePath + "reptiles_sidewinder.png"));
		cards.add(new Card("sonoran collared lizard", basePath + "reptiles_sonorancollaredlizard.png"));
		cards.add(new Card("western diamondback rattlesnake", basePath + "reptiles_westerndiamondbackrattlesnake.png"));
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public String getCategory() {
		return category;
	}
	
	public Card getCard(int i) {
		return cards.get(i);
	}
	
	public void addCard(Card card) {
		cards.add(card);
	}
	
	public void shuffleCards() {
		Collections.shuffle(cards);
	}
	
	public void removeCard(Card card) {
		cards.remove(card);
	}

}
