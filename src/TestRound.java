import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Round;

class TestRound {

	@Test
	void testCacti() {
		Round round = new Round("cacti", 4);
		assertFalse(round.getCard(0) == round.getCard(1) && round.getCard(0) == round.getCard(2));
		assertTrue(round.getScore() == 0);
		assertTrue(round.numOfMatches() == 0);
		assertThrows(IllegalArgumentException.class, () -> {round.makeGuess(0, 0); });
		assertTrue(round.isActive());
		round.makeGuess(0, 1);
		round.makeGuess(0, 2);
		round.makeGuess(0, 3);
		round.makeGuess(0, 4);
		round.makeGuess(0, 5);
		round.makeGuess(0, 6);
		round.makeGuess(0, 7);
		assertTrue(round.numOfMatches() == 1);
		round.makeGuess(1, 2);
		round.makeGuess(1, 3);
		round.makeGuess(1, 4);
		round.makeGuess(1, 5);
		round.makeGuess(1, 6);
		round.makeGuess(1, 7);
		round.makeGuess(2, 3);
		round.makeGuess(2, 4);
		round.makeGuess(2, 5);
		round.makeGuess(2, 6);
		round.makeGuess(2, 7);
		round.makeGuess(3, 4);
		round.makeGuess(3, 5);
		round.makeGuess(3, 6);
		round.makeGuess(3, 7);
		round.makeGuess(4, 5);
		round.makeGuess(4, 6);
		round.makeGuess(4, 7);
		round.makeGuess(5, 6);
		round.makeGuess(5, 7);
		round.makeGuess(6, 7);
		assertFalse(round.isActive());
	}
	@Test
	void testCities() {
		Round round = new Round("cities", 4);
		assertFalse(round.getCard(0) == round.getCard(1) && round.getCard(0) == round.getCard(2));
		assertTrue(round.getScore() == 0);
		assertTrue(round.numOfMatches() == 0);
		assertThrows(IllegalArgumentException.class, () -> {round.makeGuess(0, 0); });
		assertTrue(round.isActive());
		round.makeGuess(0, 1);
		round.makeGuess(0, 2);
		round.makeGuess(0, 3);
		round.makeGuess(0, 4);
		round.makeGuess(0, 5);
		round.makeGuess(0, 6);
		round.makeGuess(0, 7);
		assertTrue(round.numOfMatches() == 1);
		round.makeGuess(1, 2);
		round.makeGuess(1, 3);
		round.makeGuess(1, 4);
		round.makeGuess(1, 5);
		round.makeGuess(1, 6);
		round.makeGuess(1, 7);
		round.makeGuess(2, 3);
		round.makeGuess(2, 4);
		round.makeGuess(2, 5);
		round.makeGuess(2, 6);
		round.makeGuess(2, 7);
		round.makeGuess(3, 4);
		round.makeGuess(3, 5);
		round.makeGuess(3, 6);
		round.makeGuess(3, 7);
		round.makeGuess(4, 5);
		round.makeGuess(4, 6);
		round.makeGuess(4, 7);
		round.makeGuess(5, 6);
		round.makeGuess(5, 7);
		round.makeGuess(6, 7);
		assertFalse(round.isActive());
	}
	@Test
	void testMammals() {
		Round round = new Round("mammals", 4);
		assertFalse(round.getCard(0) == round.getCard(1) && round.getCard(0) == round.getCard(2));
		assertTrue(round.getScore() == 0);
		assertTrue(round.numOfMatches() == 0);
		assertThrows(IllegalArgumentException.class, () -> {round.makeGuess(0, 0); });
		assertTrue(round.isActive());
		round.makeGuess(0, 1);
		round.makeGuess(0, 2);
		round.makeGuess(0, 3);
		round.makeGuess(0, 4);
		round.makeGuess(0, 5);
		round.makeGuess(0, 6);
		round.makeGuess(0, 7);
		assertTrue(round.numOfMatches() == 1);
		round.makeGuess(1, 2);
		round.makeGuess(1, 3);
		round.makeGuess(1, 4);
		round.makeGuess(1, 5);
		round.makeGuess(1, 6);
		round.makeGuess(1, 7);
		round.makeGuess(2, 3);
		round.makeGuess(2, 4);
		round.makeGuess(2, 5);
		round.makeGuess(2, 6);
		round.makeGuess(2, 7);
		round.makeGuess(3, 4);
		round.makeGuess(3, 5);
		round.makeGuess(3, 6);
		round.makeGuess(3, 7);
		round.makeGuess(4, 5);
		round.makeGuess(4, 6);
		round.makeGuess(4, 7);
		round.makeGuess(5, 6);
		round.makeGuess(5, 7);
		round.makeGuess(6, 7);
		assertFalse(round.isActive());
	}
	@Test
	void testMountains() {
		Round round = new Round("mountains", 4);
		assertFalse(round.getCard(0) == round.getCard(1) && round.getCard(0) == round.getCard(2));
		assertTrue(round.getScore() == 0);
		assertTrue(round.numOfMatches() == 0);
		assertThrows(IllegalArgumentException.class, () -> {round.makeGuess(0, 0); });
		assertTrue(round.isActive());
		round.makeGuess(0, 1);
		round.makeGuess(0, 2);
		round.makeGuess(0, 3);
		round.makeGuess(0, 4);
		round.makeGuess(0, 5);
		round.makeGuess(0, 6);
		round.makeGuess(0, 7);
		assertTrue(round.numOfMatches() == 1);
		round.makeGuess(1, 2);
		round.makeGuess(1, 3);
		round.makeGuess(1, 4);
		round.makeGuess(1, 5);
		round.makeGuess(1, 6);
		round.makeGuess(1, 7);
		round.makeGuess(2, 3);
		round.makeGuess(2, 4);
		round.makeGuess(2, 5);
		round.makeGuess(2, 6);
		round.makeGuess(2, 7);
		round.makeGuess(3, 4);
		round.makeGuess(3, 5);
		round.makeGuess(3, 6);
		round.makeGuess(3, 7);
		round.makeGuess(4, 5);
		round.makeGuess(4, 6);
		round.makeGuess(4, 7);
		round.makeGuess(5, 6);
		round.makeGuess(5, 7);
		round.makeGuess(6, 7);
		assertFalse(round.isActive());
	}
	@Test
	void testReptiles() {
		Round round = new Round("reptiles", 4);
		assertFalse(round.getCard(0) == round.getCard(1) && round.getCard(0) == round.getCard(2));
		assertTrue(round.getScore() == 0);
		assertTrue(round.numOfMatches() == 0);
		assertThrows(IllegalArgumentException.class, () -> {round.makeGuess(0, 0); });
		assertTrue(round.isActive());
		round.makeGuess(0, 1);
		round.makeGuess(0, 2);
		round.makeGuess(0, 3);
		round.makeGuess(0, 4);
		round.makeGuess(0, 5);
		round.makeGuess(0, 6);
		round.makeGuess(0, 7);
		assertTrue(round.numOfMatches() == 1);
		round.makeGuess(1, 2);
		round.makeGuess(1, 3);
		round.makeGuess(1, 4);
		round.makeGuess(1, 5);
		round.makeGuess(1, 6);
		round.makeGuess(1, 7);
		round.makeGuess(2, 3);
		round.makeGuess(2, 4);
		round.makeGuess(2, 5);
		round.makeGuess(2, 6);
		round.makeGuess(2, 7);
		round.makeGuess(3, 4);
		round.makeGuess(3, 5);
		round.makeGuess(3, 6);
		round.makeGuess(3, 7);
		round.makeGuess(4, 5);
		round.makeGuess(4, 6);
		round.makeGuess(4, 7);
		round.makeGuess(5, 6);
		round.makeGuess(5, 7);
		round.makeGuess(6, 7);
		assertFalse(round.isActive());
	}

}
