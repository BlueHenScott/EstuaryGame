import java.awt.Point;
import java.util.ArrayList;

public class MGModel {
	int frameWidth;
	int frameHeight;
	int imageWidth = 375;
	int imageHeight = 300;
	ArrayList<Card> flipped; 
	ArrayList<Card> animals; //substantiate these  	
	ArrayList<Card> environment; //same
	
	public MGModel(int width, int height) { //, ArrayList<Card> a, ArrayList<Card> e) {
		animals = new ArrayList<Card>();
		environment = new ArrayList<Card>();
		flipped = new ArrayList<Card>(); 
		frameWidth = width; 
		frameHeight = height;
		//imageWidth = frameWidth/4;
		//imageHeight = frameHeight/3;
		setListLenghts();
		makeCards();
		
	}
	private ArrayList<Card> setListLenghts() {
		ArrayList<Card> ans = new ArrayList<Card>();
		Card card = new Card("This is a place holder card");
		for (int i = 0; i <= 5; i++) {
			animals.add(card);
			environment.add(card);
			ans.add(card);
			
		}
		// TODO Auto-generated method stub
		return ans;
		
	}
	//Matches
	// a0 e1
	// a5 e2
	// a1 e3
	// a4 e4
	// a3 e5
	// a2 e0
	private void makeCards() {
		Card a0 = new Card("a0");
		Card e1 = new Card("e1", a0);
		a0.setTarget(e1);
		animals.add(0, a0);
		environment.add(1, e1);
		
		Card a5 = new Card("a2");
		Card e2 = new Card("e2", a5);
		a5.setTarget(e2);
		animals.add(5, a5);
		environment.add(2,e2);
		
		Card a1 = new Card("a1");
		Card e3 = new Card("e3", a1);
		a1.setTarget(e3);
		animals.add(1, a1);
		environment.add(3,e3);
		
		Card a4 = new Card("a4");
		Card e4 = new Card("e4", a4);
		a4.setTarget(e4);
		animals.add(4, a4);
		environment.add(4,e4);
		
		Card a3 = new Card("a3");
		Card e5 = new Card("e5", a3);
		a3.setTarget(e5);
		animals.add(3, a3);
		environment.add(5,e5);
		
		Card a2 = new Card("a2");
		Card e0 = new Card("e0", a2);
		a2.setTarget(e0);
		animals.add(2, a2);
		environment.add(0,e0);
		animals.removeAll(setListLenghts());      //sorry cononr, i know this suck, ill figure out a better way later
		environment.removeAll(setListLenghts()); //also this

		System.out.println(animals);
		System.out.println(environment);
		
	}

	public boolean isMatch() {
		if (flipped.size() == 2) {
			Card a = flipped.get(0);
			Card b = flipped.get(1);
			
			flipped.remove(a);
			flipped.remove(b);
			
			if (b.getTarget().equals(a)) {
				b.setPaired(true);
				a.setPaired(true);
				System.out.println("its a match");
				return true;
			}
			System.out.println("not a match");
		}
		
		
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
		Card card = getFlippedClicked(clickLocation);
		if (!card.isPaired()) {
			flipped.add(card);
		}
		System.out.println(flipped);
		
	}

	public Card getFlippedClicked(Point clickLocation) {
		double xloc = clickLocation.getX();
		double yloc = clickLocation.getY();
		System.out.println(imageWidth);
		System.out.println(imageHeight);

		System.out.println(xloc);
		System.out.println(yloc);

		Card ans;
		if (xloc <= imageWidth * 2) {
			System.out.println("on left half");

			if (xloc <= imageWidth) {
				System.out.println("firs column");
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

	private Card flipCol3(double yloc) {
		Card c;
		if (yloc <= imageHeight) {
			c =environment.get(0);
			c.setFlipped(true);
		}
		else if(yloc <= imageHeight * 2) {
			c =environment.get(2);
			c.setFlipped(true);
		}
		else {
			c =environment.get(4);
			c.setFlipped(true);
			
		}
		return c;
		
	}

	private Card flipCol2(double yloc) {
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

	private Card flipCol1(double yloc) {
		Card c;
		if (yloc <= imageHeight) {
			c = animals.get(1);
			c.setFlipped(true);
		}
		else if(yloc <= imageHeight * 2) {
			System.out.println("second down");
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