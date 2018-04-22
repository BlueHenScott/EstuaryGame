import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class FishImages {
	// Imports and scales the fish images
	private static ArrayList<BufferedImage> fishImages = new ArrayList<>();
	public void importImages(){
		for (FishType ft: FishType.values()){
			String imgLoc = "images/fish/" + ft.getName() + ".png";
			BufferedImage img = createImage(imgLoc);
			fishImages.add(img);
		}
		/*
		 * TODO
		 * Auto-scale fish
		 */
	}
	
	public static BufferedImage getImage(FishType ft){
		return fishImages.get(ft.ordinal());
	}
	
	// Reads in images
		private BufferedImage createImage(String loc) {
			BufferedImage bufferedImage;
			try {
				bufferedImage = ImageIO.read(new File(loc));
				return bufferedImage;
			} catch(IOException e) {
				e.printStackTrace();
			}
			return null;
		}
}
