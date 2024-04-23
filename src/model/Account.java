package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a player's account for Memory Match. Stores login info and the
 * history of past rounds.
 * 
 * @author
 */
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private ArrayList<Round> roundHistory;

	/**
	 * To make a new user account, we need a username and password
	 * 
	 * @param username         The account's username
	 * @param password         The account's password
	 * @param fillWithMockData Set true to fill with mock data so hardcoded accounts
	 *                         have score data. Otherwise the player will have
	 *                         nothing to compete against on the leaderboard, and
	 *                         the leaderboard will display NaN or Infinite values
	 */
	public Account(String username, String password, boolean fillWithMockData) {
		this.username = username;
		this.password = password;
		this.roundHistory = new ArrayList<Round>();

		if (fillWithMockData == true) {
			generateMockData();
		}
	}

	/**
	 * Adds a round to the account's round history
	 * 
	 * @param newRound The new round to be added
	 */
	public void addRound(Round newRound) {
		this.roundHistory.add(newRound);
	}

	/**
	 * @return The account's username
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 * @return The account's password
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * @return The number of rounds played
	 */
	public int getRoundsPlayed() {
		return this.roundHistory.size();
	}

	/**
	 * @return TODO
	 */
	public int getTotalWins() {
		return this.roundHistory.size();
	}

	/**
	 * @return The average score across all rounds played by the user
	 */
	public double getAverageScore() {
		double sum = 0;
		for (Round round : roundHistory) {
			sum += round.getScore();
		}
		
		if(roundHistory.size() == 0) {
			return 0;
		}
		
		return sum / roundHistory.size();
	}

	/**
	 * @return The lowest score from all rounds played by the user
	 */
	public double getHighestScore() {
		double highestScore = Double.NEGATIVE_INFINITY;
		for (Round round : roundHistory) {
			double curScore = round.getScore();
			if (curScore > highestScore) {
				highestScore = curScore;
			}
		}
		
		// When no scores recorded
		if(highestScore == Double.NEGATIVE_INFINITY) {
			return 0;
		}
		
		return highestScore;
	}

	// Generates score data for hardcoded accounts
	private void generateMockData() {
		Random random = new Random();

		int mockRoundCount = 1 + random.nextInt(14);

		for (int i = 0; i < mockRoundCount; i += 1) {
			Round tempRound = new Round(Mode.NORMAL, "cacti", 8);
			tempRound.setNumOfMatches(8);
			tempRound.setGuesses(20 + random.nextInt(50));
			tempRound.calculateScore();
			addRound(tempRound);
		}

	}
}
