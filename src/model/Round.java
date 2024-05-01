package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a round of memory match. It keeps track of the guesses
 * made by the player, and calculates a score at the end.
 * 
 * @author Brett, Brianna, Maleika, Ray
 */
public class Round implements Serializable {

	private static final long serialVersionUID = 1L;
	private transient Table table;
	private ArrayList<Guess> guessHistory;
	private boolean isActive;
	private int numOfMatches;
	private int numOfPairs;
	private Double score;
	private Mode mode;

	/**
	 * Initialize a round of memory match by choosing a category and the number of
	 * pairs to match from that category.
	 * 
	 * @param category:   valid category accounted for in CardSet
	 * @param numOfPairs: 0 to what's the max number of cards we support?
	 */
	public Round(Mode mode, String category, int numOfPairs) {
		this.numOfPairs = numOfPairs;
		this.mode = mode;
		table = new Table(mode, category, numOfPairs);
		isActive = true;
		guessHistory = new ArrayList<Guess>();
		score = 0.0;
	}

	/**
	 * Get the card at position i.
	 * 
	 * @param i: integer index in [0, 2*numOfPairs)
	 * @return the card at position i
	 */
	public Card getCard(int i) {
		return table.getCard(i);
	}

	/**
	 * Remember to invoke this method whenever the player makes a guess!
	 * 
	 * @param guess: the guess the user makes
	 */
	public void makeGuess(Guess guess) {
		guessHistory.add(guess);
		if (isMatch(guess)) {
			numOfMatches++;
		}
		if (mode == Mode.EASY) {
			if (numOfMatches == numOfPairs * 2) {
				isActive = false;
				calculateScore();
			}
		} else {
			if (numOfMatches == numOfPairs) {
				isActive = false;
				calculateScore();
			}
		}
	}

	/**
	 * Checks if a guess is a match.
	 * 
	 * @param guess: the Guess object to check
	 * @return true if guess matched, false if not
	 */
	private boolean isMatch(Guess guess) {
		if (mode == Mode.NORMAL || mode == Mode.TIMED || mode == Mode.EASY) {
			Card firstCard = table.getCard(guess.getFirst());
			Card secondCard = table.getCard(guess.getSecond());
			return firstCard.getName() == secondCard.getName();
		} else if (mode == Mode.MATCH4) {
			Card firstCard = table.getCard(guess.getFirst());
			Card secondCard = table.getCard(guess.getSecond());
			Card thirdCard = table.getCard(guess.getThird());
			Card fourthCard = table.getCard(guess.getFourth());
			return firstCard.getName() == secondCard.getName() && secondCard.getName() == thirdCard.getName()
					&& thirdCard.getName() == fourthCard.getName();
		}
		return false;
	}

	/**
	 * Returns the status of a round.
	 * 
	 * @return true if the round is still going on, false if not
	 */
	public boolean isActive() {
		return isActive;
	}
	
	/**
	 * Ends the round.
	 */
	public void endRound() {
		calculateScore();
		isActive = false;
	}

	/**
	 * Use this to initialize the score variable when a round ends. Found this post
	 * on calculating the score:
	 * 
	 * https://math.stackexchange.com/questions/1877355/how-many-turns-on-average-does-it-take-for-a-perfect-player-to-win-concentrati
	 */
	public void calculateScore() {
		score = numOfMatches * 1.0 / guessHistory.size();
	}

	/**
	 * Returns the final score.
	 * 
	 * @return 0 if score has not been calculated, otherwise returns the score after
	 *         calculateScore has been invoked
	 */
	public Double getScore() {
		return score;
	}
	
	/**
	 * Sets the score. Used for hardcoded accounts.
	 * 
	 * @param numOfMatches The score for this round
	 */
	public void setNumOfMatches(int numOfMatches) {
		this.numOfMatches = numOfMatches;
	}
	
	/**
	 * Sets the number of guesses. Used for hardcoded accounts.
	 * 
	 * @param guessCount The number of guesses we are adding to this round
	 */
	public void setGuesses(int guessCount) {
		for(int i = 0; i < guessCount; i += 1) {
			Guess tempGuess = new Guess(-1, -2); // null values
			guessHistory.add(tempGuess);
		}
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public int numOfMatches() {
		return numOfMatches;
	}
}
