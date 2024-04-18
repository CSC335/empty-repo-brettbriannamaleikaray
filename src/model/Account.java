package model;

import java.io.Serializable;
import java.util.ArrayList;

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
	 * @param username The account's username
	 * @param password The account's password
	 */
	public Account(String username, String password) {
		this.username = username;
		this.password = password;
		this.roundHistory = new ArrayList<Round>();
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
		return sum / roundHistory.size();
	}
	
	/**
	 * @return The lowest score from all rounds played by the user
	 */
	public double getLowestScore() {
		double lowestScore = Double.POSITIVE_INFINITY;
		for (Round round : roundHistory) {
			double curScore = round.getScore();
			if (curScore < lowestScore) {
				lowestScore = curScore;
			}
		}
		return lowestScore;
	}
}
