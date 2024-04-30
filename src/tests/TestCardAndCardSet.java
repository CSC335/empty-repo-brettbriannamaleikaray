package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.Card;
import model.CardSet;

class TestCardAndCardSet {

	@Test
	void TestCard() {
		Card testCard = new Card("my name", "my file name");

		// Test get name and filename
		assertEquals("my name", testCard.getName());
		assertEquals("my file name", testCard.getFileName());

		// Test destroy
		assertEquals(false, testCard.isDestroyed());
		testCard.destroyCard();
		assertEquals(true, testCard.isDestroyed());

		// Test flip
		assertEquals(false, testCard.isFlipped());
		testCard.flipCard();
		assertEquals(true, testCard.isFlipped());
		testCard.flipCard();
		assertEquals(false, testCard.isFlipped());
	}

	@Test
	void TestCardSet() {
		String basePath = "file:src/images/cards/cacti/";

		// Test CardSet theme
		CardSet testCardSet = new CardSet("cacti");
		assertEquals("cacti", testCardSet.getCategory());
		
		CardSet testCardSet2 = new CardSet("cities");
		assertEquals("cities", testCardSet2.getCategory());
		
		CardSet testCardSet3 = new CardSet("mammals");
		assertEquals("mammals", testCardSet3.getCategory());
		
		CardSet testCardSet4 = new CardSet("mountains");
		assertEquals("mountains", testCardSet4.getCategory());
		
		CardSet testCardSet5 = new CardSet("reptiles");
		assertEquals("reptiles", testCardSet5.getCategory());

		// Test add card
		testCardSet.addCard("testCard1", basePath + "reptiles_ornatetreelizard.png");

		// Test getCards()
		Card lastCardAdded = testCardSet.getCards().get(testCardSet.getCards().size() - 1);
		assertEquals("testCard1", lastCardAdded.getName());
		assertEquals(basePath + "reptiles_ornatetreelizard.png", lastCardAdded.getFileName());
	}
}