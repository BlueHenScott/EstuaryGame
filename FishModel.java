import java.util.ArrayList;

public class FishModel {
	ArrayList<Fish> fishes = new ArrayList<>();
	int frameWidth;
	int frameHeight;
	int netX = 0;
	int netY = 0;
	int topBound = 0;
	int leftBound = 0;
	
	private int velocity = 20;
	
	public FishModel(int width, int height){
		this.frameWidth = width;
		this.frameHeight = height;
		populateFish();
	}
	
	private void populateFish(){
		 for (FishType ft: FishType.values()){
			 //System.out.println(Fish.makeRandomFish(ft, frameWidth, frameHeight));
			 fishes.add(Fish.makeRandomFish(ft, frameWidth, frameHeight));
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

	

	public int getNetX() {
		// TODO Auto-generated method stub
		return netX;
		
	}

	public int getNetY() {
		// TODO Auto-generated method stub
		return netY;
	}

	public void moveUp() {
		// TODO Auto-generated method stub
		netY -= velocity;
	}

	public void moveLeft() {
		// TODO Auto-generated method stub
		netX -= velocity;
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		netX += velocity;
	}

	public void moveDown() {
		// TODO Auto-generated method stub
		netY += velocity;
	}
	
	
	
	
	
	
}