/**
 * @author Elena
 * A Fish has a location (x and y), size, speed (x and y),
 * direction of travel, and a species.
 * 
 * Fish species determines location, size, and image. (location restrictions not implemented yet)
 * Every fish has random movement.
 * 
 */
import java.util.Random;

public class Fish {
	int xloc, yloc;
	int xSpeed, ySpeed;
	int size;
	Direction direction;
	FishType species;
	int imageWidth;
	int imageHeight;
	int frameWidth;
	int frameHeight;
	int rightBound;
	int bottomBound;
	
	public Fish(int xloc, int yloc, int xSpeed, int ySpeed, int size, Direction direction) {
		this.xloc = xloc;
		this.yloc = yloc; 
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		this.size = size;
		this.direction = direction;
	}
	private void findBounds(int imageWidth, int imageHeight){
		rightBound = frameWidth - imageWidth;
		bottomBound = frameHeight - imageHeight;
	}
	
	// Setters
	public void setImage(int w,int h){
		imageWidth = w;
		imageHeight = h;

	}
	public void setFrame(int w, int h){
		frameWidth = w;
		frameHeight = h;
	}
	// Getters
	public int getWidth(){
		return imageWidth;
	}
	public int getHeight(){
		return imageHeight;
	}
	public int getXLoc() {
		return xloc;
	}
	public int getYLoc() {
		return yloc;
	}
	public int getXSpeed() {
		return xSpeed;
	}
	public int getYSpeed() {
		return ySpeed;
	}
	public int getSize() {
		return size;
	}
	public Direction getDirection() {
		return direction;
	}
	public FishType getSpecies() {
		return species;
	}
	
	// randomly generates int from 0-7 which determines direction
	public void makeRandom() {
		Random r = new Random();
		int randomDir = r.nextInt(8);
		direction = Direction.values()[randomDir];
	}
	
	/* to be updated once there are more FishTypes; limits where species can move
	public void speciesLimits() {
		switch(species) {
			case HOGCHOKER:
		}
	}
	*/
	
	// increments and decrements xloc and yloc to move in specified direction
	public void move() {
		switch(direction) {
			case NORTH: {
				yloc--;
			}
			case SOUTH: {
				yloc++;
			}
			case EAST: {
				xloc++;
			}
			case WEST: {
				xloc--;
			}
			case NORTHEAST: {
				xloc++;
				yloc--;
			}
			case NORTHWEST: {
				xloc--;
				yloc--;
			}
			case SOUTHEAST: {
				xloc++;
				yloc++;
			}
			case SOUTHWEST: {
				xloc--;
				yloc++;
			}
		}
	}
	
}
