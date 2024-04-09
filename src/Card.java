
public class Card {
	
	private String name;
	private String fileName;
	private boolean hasBeenCorrectlyGuessed;
	
	public Card(String name, String fileName) {
		this.name = name;
		this.fileName = fileName;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public void setCorrectlyGuessed() {
		hasBeenCorrectlyGuessed = true;
	}
	
	public boolean getHasBeenCorrectlyGuessed() {
		return hasBeenCorrectlyGuessed;
	}
	
}
