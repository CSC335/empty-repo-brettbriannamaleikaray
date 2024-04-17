package model;
import java.util.Random;

public class MockUserAccount {
	Random random = new Random();

	private String userName;
	private double lowestScore;
	private double roundsPlayed;
	private double totalWins;
	private double averageScore;
	private int sumOfAllScores;
	
	public MockUserAccount(String argUserName) {
		userName = argUserName;
		lowestScore = 5 + random.nextInt(15);
		roundsPlayed = 15 + random.nextInt(30);
		totalWins = 0 + random.nextInt(15);
		sumOfAllScores = 100 + random.nextInt(80);
		averageScore = Math.round((sumOfAllScores / roundsPlayed) * 100) / 100;
		
		averageScore = Math.round((sumOfAllScores / roundsPlayed) * 100);
		averageScore = averageScore / 100;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getLowestScore() {
		return (int) lowestScore;
	}

	public void setLowestScore(int lowestScore) {
		this.lowestScore = lowestScore;
	}

	public int getRoundsPlayed() {
		return (int) roundsPlayed;
	}

	public void setRoundsPlayed(int roundsPlayed) {
		this.roundsPlayed = roundsPlayed;
	}

	public int getTotalWins() {
		return (int) totalWins;
	}

	public void setTotalWins(int totalWins) {
		this.totalWins = totalWins;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setWinPercentage(double averageScore) {
		this.averageScore = averageScore;
	}
	
}