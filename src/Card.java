
public class Card {
	
	String name;
	public Card target;
	
	public Card() {
		
	}
	@Override
	public boolean equals(Object other) {
		if (other instanceof Card) {
			Card card = (Card) other;
			if (card.name == this.name) {
				return true; 
			}
			else return false;
		}
		else return false;
		
	}

}
