import java.util.ArrayList;
import java.util.HashSet;

/**
 * This class represents a round of memory match. It keeps track of the guesses
 * made by the player, and calculates a score at the end.
 * 
 * @author Brett, Brianna, Maleika, Ray
 */
public class Round {

	private Table table;
	private ArrayList<Guess> guessHistory;
	private boolean isActive;
	private int numOfMatches;
	private int numOfPairs;
	private double score;

	/**
	 * Initialize a round of memory match by choosing a category and the number
	 * of pairs to match from that category.
	 * 
	 * @param category:   valid category accounted for in CardSet
	 * @param numOfPairs: 0 to what's the max number of cards we support?
	 */
	public Round(String category, int numOfPairs) {
		this.numOfPairs = numOfPairs;
		table = new Table(category, numOfPairs);
		isActive = true;
		guessHistory = new ArrayList<Guess>();
	}

	/**
	 * Remember to invoke this method whenever the player makes a guess!
	 * 
	 * @param first:  position of first flip
	 * @param second: position of second flip
	 */
	public void makeGuess(int first, int second) {
		Guess guess = new Guess(first, second);
		guessHistory.add(guess);
		if (isMatch(guess)) {
			numOfMatches++;
		}
		if (numOfMatches == numOfPairs) {
			isActive = false;
			calculateScore();
		}
	}

	/**
	 * Checks if a guess is a match.
	 * 
	 * @param guess: the Guess object to check
	 * @return true if guess matched, false if not
	 */
	private boolean isMatch(Guess guess) {
		Card firstCard = table.getCard(guess.first());
		Card secondCard = table.getCard(guess.second());
		return firstCard.getName() == secondCard.getName();
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
	 * Use this to initialize the score variable when a round ends. Found this
	 * post on calculating the score:
	 * 
	 * https://math.stackexchange.com/questions/1877355/how-many-turns-on-average-does-it-take-for-a-perfect-player-to-win-concentrati
	 */
	private void calculateScore() {
		// Currently the score is just the accuracy of guesses
		score = numOfMatches / guessHistory.size();
	}
	
	public double getScore() {
		return score;
	}
	
}
