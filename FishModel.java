import java.util.ArrayList;

public class FishModel {
	ArrayList<Fish> fishes;
	int frameWidth = 1500;
	int frameHeight = 900;
	int netX = 0;
	int netY = 0;
	int topBound = 0;
	int leftBound = 0;
	
	
	
	private void populateFish(){
		 for (FishType ft: FishType.values()){
			 Fish.makeRandomFish(ft, frameWidth, frameHeight);
		 }
	}
	
	private void moveFish(){
		
	}
	
	public ArrayList<Fish> getFishList(){
		return fishes;
	}

	public void update() {
		// TODO Auto-generated method stub
		
	}

	public int getPlayerX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getPlayerY() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void moveUp() {
		// TODO Auto-generated method stub
		
	}

	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	public void moveDown() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}