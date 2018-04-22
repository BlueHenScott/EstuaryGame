import java.awt.Image;
import java.awt.image.BufferedImage;

public class Card {
	
	public String name;
	public Card target;
	public boolean isFlipped;
	public boolean isPaired;
	public Image img;
	public Card(String n, Card t) {
		name = n;
		target = t;
		isFlipped = false;
		isPaired = false;
	}
	public Card(String n) {
		name = n;
		//target = t;
		isFlipped = false;
		isPaired = false;
	}
	
	public boolean isFlipped() {
		return isFlipped;
	}
	public void setFlipped(boolean isFlipped) {
		this.isFlipped = isFlipped;
	}
	public boolean isPaired() {
		return isPaired;
	}
	public void setPaired(boolean isPaired) {
		this.isPaired = isPaired;
	}
	public Card() {
		
	}
	@Override
	public boolean equals(Object other) {
		if (other instanceof Card) {
			Card card = (Card) other;
			if (card.name.equals(this.name)) {
				return true; 
			}
			else return false;
		}
		else return false;
		
	}
	public Card getTarget() {
		// TODO Auto-generated method stub
		return target;
	}
	public void setTarget(Card t) {
		// TODO Auto-generated method stub
		target = t;
	}
	public String toString() { 
		return name;
	}
	

}
