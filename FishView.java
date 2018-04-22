import java.awt.Color;
import java.awt.Graphics;
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
	private FishImages fishImages = new FishImages();
	
	// Player Variables
	private int playerX;
	private int playerY;
	private BufferedImage net;
	
	// Background image
	private BufferedImage background;
	
	//Draw Delay
	private int drawDelay = 50;
	
	// Transparent Color
	private Color transparent = new Color(0,0,0,0);
	
	public FishView(JFrame f) {
		frame = f;
		
		viewWidth = 1500;
		viewHeight = 900;
		
		// Player net image;
		String playerImageLoc = "images/fishgame/net.png";
		String backgroundLoc = "images/fish/background.png";
		net = createImage(playerImageLoc);
		background = createImage(backgroundLoc);
		fishImages.importImages();
		
		frame.setBackground(Color.white);
		frame.getContentPane().add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(viewWidth, viewHeight);
		frame.setVisible(true);
		frame.setFocusable(true);
		frame.requestFocus();
	}
	
	public int getDrawDelay() {
		return drawDelay;
	}
	
	public void update(ArrayList<Fish> fish, int pX, int pY) {
		playerX = pX;
		playerY = pY;
		fishList = fish;
		
		frame.repaint();
	}
	
	protected void paintComponent(Graphics g) {
		g.drawImage(background, 0, 0, null, this);
		for(Fish f: fishList) {
			g.drawImage(FishImages.getImage(f.getSpecies()), f.getXLoc(), f.getYLoc(), transparent, this);
		}
		g.drawImage(net, playerX, playerY, transparent, this);
	}
	
	
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

	public void addKeyInput(KeyListener kL) {
		frame.addKeyListener(kL);
		System.out.println("KeyListenerAdded");
	}
}
