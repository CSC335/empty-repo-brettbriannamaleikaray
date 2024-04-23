package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Guess;
import model.Mode;
import model.Round;

class TestRound {

	@Test
	void testCacti() {
		Round round = new Round(Mode.NORMAL, "cacti", 4);
		assertFalse(round.getCard(0) == round.getCard(1) && round.getCard(0) == round.getCard(2));
		assertTrue(round.getScore() == 0);
		assertTrue(round.numOfMatches() == 0);
		assertThrows(IllegalArgumentException.class, () -> {round.makeGuess(new Guess(0,0)); });
		assertTrue(round.isActive());
		round.makeGuess(new Guess(0,1));
		round.makeGuess(new Guess(0,2));
		round.makeGuess(new Guess(0,3));
		round.makeGuess(new Guess(0,4));
		round.makeGuess(new Guess(0,5));
		round.makeGuess(new Guess(0,6));
		round.makeGuess(new Guess(0,7));
		assertTrue(round.numOfMatches() == 1);
		round.makeGuess(new Guess(1,2));
		round.makeGuess(new Guess(1,3));
		round.makeGuess(new Guess(1,4));
		round.makeGuess(new Guess(1,5));
		round.makeGuess(new Guess(1,6));
		round.makeGuess(new Guess(1,7));
		round.makeGuess(new Guess(2,3));
		round.makeGuess(new Guess(2,4));
		round.makeGuess(new Guess(2,5));
		round.makeGuess(new Guess(2,6));
		round.makeGuess(new Guess(2,7));
		round.makeGuess(new Guess(3,4));
		round.makeGuess(new Guess(3,5));
		round.makeGuess(new Guess(3,6));
		round.makeGuess(new Guess(3,7));
		round.makeGuess(new Guess(4,5));
		round.makeGuess(new Guess(4,6));
		round.makeGuess(new Guess(4,7));
		round.makeGuess(new Guess(5,6));
		round.makeGuess(new Guess(5,7));
		round.makeGuess(new Guess(6,7));
		assertFalse(round.isActive());
	}
	@Test
	void testCities() {
		Round round = new Round(Mode.NORMAL, "cities", 4);
		assertFalse(round.getCard(0) == round.getCard(1) && round.getCard(0) == round.getCard(2));
		assertTrue(round.getScore() == 0);
		assertTrue(round.numOfMatches() == 0);
		assertThrows(IllegalArgumentException.class, () -> {round.makeGuess(new Guess(0,0)); });
		assertTrue(round.isActive());
		round.makeGuess(new Guess(0,1));
		round.makeGuess(new Guess(0,2));
		round.makeGuess(new Guess(0,3));
		round.makeGuess(new Guess(0,4));
		round.makeGuess(new Guess(0,5));
		round.makeGuess(new Guess(0,6));
		round.makeGuess(new Guess(0,7));
		assertTrue(round.numOfMatches() == 1);
		round.makeGuess(new Guess(1,2));
		round.makeGuess(new Guess(1,3));
		round.makeGuess(new Guess(1,4));
		round.makeGuess(new Guess(1,5));
		round.makeGuess(new Guess(1,6));
		round.makeGuess(new Guess(1,7));
		round.makeGuess(new Guess(2,3));
		round.makeGuess(new Guess(2,4));
		round.makeGuess(new Guess(2,5));
		round.makeGuess(new Guess(2,6));
		round.makeGuess(new Guess(2,7));
		round.makeGuess(new Guess(3,4));
		round.makeGuess(new Guess(3,5));
		round.makeGuess(new Guess(3,6));
		round.makeGuess(new Guess(3,7));
		round.makeGuess(new Guess(4,5));
		round.makeGuess(new Guess(4,6));
		round.makeGuess(new Guess(4,7));
		round.makeGuess(new Guess(5,6));
		round.makeGuess(new Guess(5,7));
		round.makeGuess(new Guess(6,7));
		assertFalse(round.isActive());
	}
	
	@Test
	void testMammals() {
		Round round = new Round(Mode.NORMAL, "mammals", 4);
		assertFalse(round.getCard(0) == round.getCard(1) && round.getCard(0) == round.getCard(2));
		assertTrue(round.getScore() == 0);
		assertTrue(round.numOfMatches() == 0);
		assertThrows(IllegalArgumentException.class, () -> {round.makeGuess(new Guess(0,0)); });
		assertTrue(round.isActive());
		round.makeGuess(new Guess(0,1));
		round.makeGuess(new Guess(0,2));
		round.makeGuess(new Guess(0,3));
		round.makeGuess(new Guess(0,4));
		round.makeGuess(new Guess(0,5));
		round.makeGuess(new Guess(0,6));
		round.makeGuess(new Guess(0,7));
		assertTrue(round.numOfMatches() == 1);
		round.makeGuess(new Guess(1,2));
		round.makeGuess(new Guess(1,3));
		round.makeGuess(new Guess(1,4));
		round.makeGuess(new Guess(1,5));
		round.makeGuess(new Guess(1,6));
		round.makeGuess(new Guess(1,7));
		round.makeGuess(new Guess(2,3));
		round.makeGuess(new Guess(2,4));
		round.makeGuess(new Guess(2,5));
		round.makeGuess(new Guess(2,6));
		round.makeGuess(new Guess(2,7));
		round.makeGuess(new Guess(3,4));
		round.makeGuess(new Guess(3,5));
		round.makeGuess(new Guess(3,6));
		round.makeGuess(new Guess(3,7));
		round.makeGuess(new Guess(4,5));
		round.makeGuess(new Guess(4,6));
		round.makeGuess(new Guess(4,7));
		round.makeGuess(new Guess(5,6));
		round.makeGuess(new Guess(5,7));
		round.makeGuess(new Guess(6,7));
		assertFalse(round.isActive());
	}
	@Test
	void testMountains() {
		Round round = new Round(Mode.NORMAL, "mountains", 4);
		assertFalse(round.getCard(0) == round.getCard(1) && round.getCard(0) == round.getCard(2));
		assertTrue(round.getScore() == 0);
		assertTrue(round.numOfMatches() == 0);
		assertThrows(IllegalArgumentException.class, () -> {round.makeGuess(new Guess(0,0)); });
		assertTrue(round.isActive());
		round.makeGuess(new Guess(0,1));
		round.makeGuess(new Guess(0,2));
		round.makeGuess(new Guess(0,3));
		round.makeGuess(new Guess(0,4));
		round.makeGuess(new Guess(0,5));
		round.makeGuess(new Guess(0,6));
		round.makeGuess(new Guess(0,7));
		assertTrue(round.numOfMatches() == 1);
		round.makeGuess(new Guess(1,2));
		round.makeGuess(new Guess(1,3));
		round.makeGuess(new Guess(1,4));
		round.makeGuess(new Guess(1,5));
		round.makeGuess(new Guess(1,6));
		round.makeGuess(new Guess(1,7));
		round.makeGuess(new Guess(2,3));
		round.makeGuess(new Guess(2,4));
		round.makeGuess(new Guess(2,5));
		round.makeGuess(new Guess(2,6));
		round.makeGuess(new Guess(2,7));
		round.makeGuess(new Guess(3,4));
		round.makeGuess(new Guess(3,5));
		round.makeGuess(new Guess(3,6));
		round.makeGuess(new Guess(3,7));
		round.makeGuess(new Guess(4,5));
		round.makeGuess(new Guess(4,6));
		round.makeGuess(new Guess(4,7));
		round.makeGuess(new Guess(5,6));
		round.makeGuess(new Guess(5,7));
		round.makeGuess(new Guess(6,7));
		assertFalse(round.isActive());
	}
	@Test
	void testReptiles() {
		Round round = new Round(Mode.NORMAL, "reptiles", 4);
		assertFalse(round.getCard(0) == round.getCard(1) && round.getCard(0) == round.getCard(2));
		assertTrue(round.getScore() == 0);
		assertTrue(round.numOfMatches() == 0);
		assertThrows(IllegalArgumentException.class, () -> {round.makeGuess(new Guess(0,0)); });
		assertTrue(round.isActive());
		round.makeGuess(new Guess(0,1));
		round.makeGuess(new Guess(0,2));
		round.makeGuess(new Guess(0,3));
		round.makeGuess(new Guess(0,4));
		round.makeGuess(new Guess(0,5));
		round.makeGuess(new Guess(0,6));
		round.makeGuess(new Guess(0,7));
		assertTrue(round.numOfMatches() == 1);
		round.makeGuess(new Guess(1,2));
		round.makeGuess(new Guess(1,3));
		round.makeGuess(new Guess(1,4));
		round.makeGuess(new Guess(1,5));
		round.makeGuess(new Guess(1,6));
		round.makeGuess(new Guess(1,7));
		round.makeGuess(new Guess(2,3));
		round.makeGuess(new Guess(2,4));
		round.makeGuess(new Guess(2,5));
		round.makeGuess(new Guess(2,6));
		round.makeGuess(new Guess(2,7));
		round.makeGuess(new Guess(3,4));
		round.makeGuess(new Guess(3,5));
		round.makeGuess(new Guess(3,6));
		round.makeGuess(new Guess(3,7));
		round.makeGuess(new Guess(4,5));
		round.makeGuess(new Guess(4,6));
		round.makeGuess(new Guess(4,7));
		round.makeGuess(new Guess(5,6));
		round.makeGuess(new Guess(5,7));
		round.makeGuess(new Guess(6,7));
		assertFalse(round.isActive());
	}

}
