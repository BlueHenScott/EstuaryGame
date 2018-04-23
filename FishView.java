
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FishView extends JPanel{	
	// Constants for View Size
	private int viewWidth;
	private int viewHeight;
	
	JFrame frame;
	
	// Fishes
	private ArrayList<Fish> fishList = new ArrayList<Fish>();
	private FishImages fishImages;
	
	// Player Variables
	private int playerX;
	private int playerY;
	private BufferedImage net;
	
	// Background image
	private BufferedImage background;
		
	// Transparent Color
	private Color transparent = new Color(0,0,0,0);
	
	public FishView(JFrame f) {
		frame = f;
		
		viewWidth = frame.getWidth();
		viewHeight = frame.getHeight();
		
		// Player net image;
		String playerImageLoc = "images/fish/net.png";
		String backgroundLoc = "images/fish/background.png";
		net = createImage(playerImageLoc);
		background = createImage(backgroundLoc);
    background = scaleImage(background, viewWidth, viewHeight);

		fishImages = new FishImages();
		fishImages.importImages();
		
		// Remove all previous panels from the frame
		frame.getContentPane().removeAll();
		// Add this game to the jFrame and focus on it
		frame.setBackground(Color.white);
		frame.getContentPane().add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(viewWidth, viewHeight);
		frame.setVisible(true);
		frame.setFocusable(true);
		// Set focus on the panel
		this.requestFocus();
	}
	
	// Update is called on ever timer tick. 
	public void update(ArrayList<Fish> fish, int pX, int pY) {
		// update the player's position
		playerX = pX;
		playerY = pY;
		// Receive any changes made to the fish
		fishList = fish;
		// Repaint the frame with the new information
		repaint();
	}
	
	protected void paintComponent(Graphics g) {

		// Draw the background image
		g.drawImage(background, 0, 0, Color.black, this);
		// Draw the net
		g.drawImage(net, playerX, playerY, Color.black, this);
		// Draw each fish in the list
		for(Fish f: fishList) {
			g.drawImage(FishImages.getImage(f.getSpecies()), f.getXLoc(), f.getYLoc(), Color.black, this);
		}
		
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

	// Adds the key listener to our jpanel.
	public void addKeyInput(KeyListener kL) {
		this.addKeyListener(kL);
	}
	
	// Accessors
	public int getWidth() {
		return viewWidth;
	}
	public int getHeight() {
		return viewHeight;
	}
	
	
	// Scales buffered images
	private BufferedImage scaleImage(BufferedImage img, int newWidth, int newHeight) {
		Image tmp = img.getScaledInstance(viewWidth, viewHeight, Image.SCALE_SMOOTH);
	    BufferedImage dimg = new BufferedImage(viewWidth, viewHeight, BufferedImage.TYPE_INT_ARGB);

	    Graphics2D g2d = dimg.createGraphics();
	    g2d.drawImage(tmp, 0, 0, null);
	    g2d.dispose();
	    return dimg;
	}	
	

}
