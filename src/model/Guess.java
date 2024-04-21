package model;

import java.io.Serializable;

/**
 * A single guess consists of the positions of the first and second cards.
 * 
 * @author Brett, Brianna, Maleika, Ray
 */
public class Guess implements Serializable {

	private int first;
	private int second;
	private int third;
	private int fourth;

	public Guess(int first, int second) {
		if (first == second) {
			String msg = "Cannot guess a card against itself!";
			throw new IllegalArgumentException(msg);
		}
		this.first = first;
		this.second = second;
	}

	public Guess(int first, int second, int third, int fourth) {
		this.first = first;
		this.second = second;
		this.third = third;
		this.fourth = fourth;
	}

	public int getFirst() {
		return this.first;
	}

	public int getSecond() {
		return this.second;
	}
	
	public int getThird() {
		return this.third;
	}
	
	public int getFourth() {
		return this.fourth;
	}

}
