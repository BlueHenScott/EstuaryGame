/**
 * @author Elena
 * A Fish has a location (x and y), size, speed (x and y),
 * direction of travel, and a species.
 * 
 * Fish species determines location, size, and image. (location restrictions not implemented yet)
 * Every fish has random movement.
 * 
 */
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Fish {
	int xloc, yloc;
	int imageWidth, imageHeight;
	int xSpeed;
	int ySpeed;
	
	Direction direction;
	FishType species;
	
	
	public Fish(FishType species, int xloc, int yloc, Direction direction, int iWidth, int iHeight, int xSpeed, int ySpeed) {
		this.species = species;
		this.xloc = xloc;
		this.yloc = yloc; 
		this.direction = direction;
		this.imageWidth = iWidth;
		this.imageHeight = iHeight;
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
		
	}
	
	
	public static Fish makeRandomFish(FishType type, int frameWidth, int frameHeight){
		Random r = new Random();
		int iWidth = (int) (type.getSize() * FishImages.getImage(type).getWidth());
		int iHeight = (int) (type.getSize() * FishImages.getImage(type).getHeight());
		int xSpeed = (int) (type.getSpeed() * FishImages.getImage(type).getWidth());
		int ySpeed = (int) (type.getSpeed() * FishImages.getImage(type).getHeight());
		int x = r.nextInt(frameWidth - iWidth);
		int y = r.nextInt(frameHeight-iHeight);
		Direction dir = Direction.values()[r.nextInt(Direction.values().length)];
		return new Fish(type, x, y, dir, iWidth, iHeight, xSpeed, ySpeed);	
	}
	
	
	
	
	
	
	
	
	
	// Getters
	
	public int getXLoc() {
		return xloc;
	}
	public int getYLoc() {
		return yloc;
	}
	
	
	public Direction getDirection() {
		return direction;
	}
	public FishType getSpecies() {
		return species;
	}
	
	//
	
	// randomly generates int from 0-7 which determines direction
	public void randomizeDirection() {
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
				yloc -= ySpeed;
			}
			case SOUTH: {
				yloc+= xSpeed;
			}
			case EAST: {
				xloc+= xSpeed;
			}
			case WEST: {
				xloc-= xSpeed;
			}
			case NORTHEAST: {
				xloc+=xSpeed;
				yloc-=ySpeed;
			}
			case NORTHWEST: {
				xloc-=xSpeed;
				yloc-=ySpeed;
			}
			case SOUTHEAST: {
				xloc+=xSpeed;
				yloc+=ySpeed;
			}
			case SOUTHWEST: {
				xloc-=xSpeed;
				yloc+= ySpeed;
			}
		}
	}
	
}

class FishImages{
	static ArrayList<BufferedImage> fishImages = new ArrayList<>();
	
	public void importImages(){
		for (FishType ft: FishType.values()){
			String imgLoc = "images/fish/" + ft.getName() + ".png";
			BufferedImage img = createImage(imgLoc);
			fishImages.add(img);
		}
	}
	
	private BufferedImage createImage(String loc){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(loc));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    }
	
	public static BufferedImage getImage(FishType ft){
		return fishImages.get(ft.ordinal());
		
	}
}
