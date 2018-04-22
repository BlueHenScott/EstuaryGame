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
	
	
	
	
	
	
	
	
}
