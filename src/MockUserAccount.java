import java.util.Random;

public class MockUserAccount {
	Random random = new Random();

	private String userName;
	private double lowestScore;
	private double roundsPlayed;
	private double totalWins;
	private String winPercentage;

	public MockUserAccount() {
		userName = "Test Account " + random.nextInt(9999);
		lowestScore = 5 + random.nextInt(15);
		roundsPlayed = 15 + random.nextInt(30);
		totalWins = 0 + random.nextInt(15);
		winPercentage = (int) Math.round((totalWins / roundsPlayed) * 100) + "%";
		//winPercentage = winPercentage / 100;
	}
	
	public MockUserAccount(String argUserName) {
		userName = argUserName;
		lowestScore = 5 + random.nextInt(15);
		roundsPlayed = 15 + random.nextInt(30);
		totalWins = 0 + random.nextInt(15);
		winPercentage = (int) Math.round((totalWins / roundsPlayed) * 100) + "%";
		//winPercentage = winPercentage / 100;
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

	public String getWinPercentage() {
		return winPercentage;
	}

	public void setWinPercentage(String winPercentage) {
		this.winPercentage = winPercentage;
	}
	
}