import java.util.ArrayList;

public class MGModel {
	int frameWidth;
	int frameHeight;
	int imageWidth;
	int imageHeight;
	Card currentPic; 
	ArrayList<Card> animals; 	
	ArrayList<Card> environment;
	
	public MGModel() {
		
		
	}
	
	public boolean isMatch(Card a, Card b) {
		if (a.target.equals(b.target)) {
			return true;
		}
		else {
			return false; 
		}
		
	}
	
	
	

}
