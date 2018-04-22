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
	
	private int bottomBound(Fish fish){
		return frameHeight - fish.imageHeight;
	}
	private int rightBound(Fish fish){
		return frameWidth - fish.imageWidth;
	}
	
	
	public void update(){
		for (Fish f: fishes){
			moveFish(f);
		}
	}
	
	
	private void moveFish(Fish fish){
		int newX = fish.xloc + fish.xIncriment() * fish.xSpeed;
		int newY = fish.yloc + fish.yIncriment() * fish.ySpeed;
	
		if (newX < leftBound) {
			newX = leftBound;
			fish.flipDirection(Direction.WEST);

		}
		if (newX > rightBound( fish)){
			newX = rightBound( fish);
			fish.flipDirection(Direction.EAST);

		}
		if (newY < topBound){
			newY = topBound;
			fish.flipDirection(Direction.NORTH);

		}
		if (newY > bottomBound(fish)){
			newY = bottomBound(fish);
			fish.flipDirection(Direction.SOUTH);

		}
		fish.xloc = newX;
		fish.yloc = newY;
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