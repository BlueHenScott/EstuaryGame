import java.awt.Point;
import java.util.ArrayList;

public class MGModel {
	int frameWidth;
	int frameHeight;
	int imageWidth;
	int imageHeight;
	ArrayList<Card> Flipped; 
	ArrayList<Card> animals; //substantiate these  	
	ArrayList<Card> environment; //same
	
	public MGModel(int width, int height) { //, ArrayList<Card> a, ArrayList<Card> e) {
		frameWidth = width; 
		frameHeight = height;
		makeCards();
		
	}
	
	private void makeCards() {
		// TODO Auto-generated method stub
		
	}

	public boolean isMatch() {
		if (Flipped.size() == 2) {
			Card a = Flipped.get(0);
			Card b = Flipped.get(1);
			
			Flipped.remove(a);
			Flipped.remove(b);
			
			if (b.getTarget().equals(a)) {
				b.setPaired(true);
				a.setPaired(true);
				System.out.println("its a match");
				return true;
			}
		}
		System.out.println("not a match");
		return false;
		
	}
	
	public void flip(Card a) {
		a.setFlipped(true);
	}
	
	public void pair(Card a) {
		a.setPaired(true);
	}
	//this is a really gross way to do things but I did it like this anyway
	public void flipClicked(Point clickLocation) {
		Flipped.add(getFlippedClicked(clickLocation));
	}

	public Card getFlippedClicked(Point clickLocation) {
		double xloc = clickLocation.getX();
		double yloc = clickLocation.getY();
		Card ans;
		if (xloc <= imageWidth + imageWidth) {
			if (xloc <= imageWidth) {
				ans = flipCol1(yloc);
			}
			else {
				ans = flipCol2(yloc);
			}
		}
		else {
			if (xloc >= imageWidth * 3) {
				ans = flipCol4(yloc);
			}
			else {
				ans = flipCol3(yloc);
			}
		}
		return ans;
	}
	
	private Card flipCol4(double yloc) {
		Card c;
		if (yloc <= imageHeight) {
			c =environment.get(2);
			c.setFlipped(true);
			
		}
		else if(yloc <= imageHeight * 2) {
			c =environment.get(4);
			c.setFlipped(true);
		}
		else {
			c =environment.get(5);
			c.setFlipped(true);
		}
		return c;
		
	}

	private Card flipCol3(double yloc) {
		Card c;
		if (yloc <= imageHeight) {
			c =environment.get(1);
			c.setFlipped(true);
		}
		else if(yloc <= imageHeight * 2) {
			c =environment.get(3);
			c.setFlipped(true);
		}
		else {
			c =environment.get(5);
			c.setFlipped(true);
			
		}
		return c;
		
	}

	private Card flipCol2(double yloc) {
		Card c;
		if (yloc <= imageHeight) {
			c = animals.get(2);
			c.setFlipped(true);
		}
		else if(yloc <= imageHeight * 2) {
			c = animals.get(4);
			c.setFlipped(true);
		}
		else {
			c = animals.get(6);
			c.setFlipped(true);
			
		}
		return c;
		
	}

	private Card flipCol1(double yloc) {
		Card c;
		if (yloc <= imageHeight) {
			c = animals.get(1);
			c.setFlipped(true);
		}
		else if(yloc <= imageHeight * 2) {
			c = animals.get(3);
			c.setFlipped(true);
		}
		else {
			c = animals.get(5);
			c.setFlipped(true);
			
		}
		return c;
		
	}
	
	
	
	
	
	

}
