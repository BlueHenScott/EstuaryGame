import java.util.ArrayList;

public class MGModel {
	int frameWidth;
	int frameHeight;
	int imageWidth;
	int imageHeight;
	Card currentPic; 
	ArrayList<Card> animals; 	
	ArrayList<Card> environment;
	
	public MGModel(int width, int height, ArrayList<Card> a, ArrayList<Card> e) {
		frameWidth = width; 
		frameHeight = height;
		animals = a; 
		environment = e;
		
	}
	
	public boolean isMatch(Card a, Card b) {
		if (a.target.equals(b.target)) {
			return true;
		}
		else {
			return false; 
		}
		
	}
	
	public void flip(Card a) {
		a.setFlipped(true);
	}
	
	public void pair(Card a) {
		a.setPaired(true);
	}
	
	
	
	
	

}
