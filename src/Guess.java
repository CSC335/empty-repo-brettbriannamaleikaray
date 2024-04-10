/**
 * A single guess consists of the positions of the first and second cards.
 * 
 * @author Brett, Brianna, Maleika, Ray
 */
public class Guess {
	
	private int first;
	private int second;

	public Guess(int first, int second) {
		if (first == second) {
			String msg = "Cannot guess a card against itself!";
			throw new IllegalArgumentException(msg);
		}
		this.first = first;
		this.second = second;
	}

	public int first() {
		return this.first;
	}

	public int second() {
		return this.second;
	}
	
}
