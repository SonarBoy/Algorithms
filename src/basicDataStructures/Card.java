package basicDataStructures;

public class Card {
	
	private final String SUIT;
	private final String RANK;
	
	
	public Card(String s, String r) {
		this.SUIT = s;
		this.RANK = r;
	}


	public String getSUIT() {
		return this.SUIT;
	}


	public String getRANK() {
		return this.RANK;
	}
	
	@Override
	public String toString() {
		return this.SUIT + " of " + this.RANK;
	}
	
}
