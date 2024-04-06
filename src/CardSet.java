import java.util.ArrayList;

public class CardSet {
	
	private String category;
	private ArrayList<Card> cards;
	
	public CardSet(String category) {
		this.category = category;
		cards = new ArrayList<>();
		// TODO: update category names
		if (category.equals("XXX")) {
			setCategory1Cards();
		} else if (category.equals("XXX")) {
			setCategory2Cards();
		} else if (category.equals("XXX")) {
			setCategory3Cards();
		} else if (category.equals("XXX")) {
			setCategory4Cards();
		} else if (category.equals("XXX")) {
			setCategory5Cards();
		}
	}
	
	// TODO: update card names and their file names
	private void setCategory1Cards() {
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
	}
	
	private void setCategory2Cards() {
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
	}
	
	private void setCategory3Cards() {
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
	}
	
	private void setCategory4Cards() {
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
	}
	
	private void setCategory5Cards() {
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
		cards.add(new Card("", ""));
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public String getCategory() {
		return category;
	}

}
