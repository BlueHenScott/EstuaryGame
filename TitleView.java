import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.*;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TitleView extends JPanel{
	
	// Constants for the size of the view
	private int viewWidth = 1500;
	private int viewHeight = 900;
	
	
	private JFrame frame;
	private JButton startButton = new JButton("Start");
	
	// Background image
	private BufferedImage background;
	
	public TitleView(JFrame f) {
		frame = f;
		
		// Player net image;
		String backgroundLoc = "images/titlescreen.png";
		background = createImage(backgroundLoc);
		startButton.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JPanel buttonPanel = new JPanel(new GridLayout());
		buttonPanel.setBackground(Color.BLUE);
	    buttonPanel.add(startButton);
	    
	    JPanel imagePanel = new JPanel (new GridLayout());
	    JLabel picLabel = new JLabel(new ImageIcon(background.getScaledInstance(viewWidth, viewHeight-175, Image.SCALE_SMOOTH)));
	    imagePanel.add(picLabel);
		// Add this game to the jFrame and focus on it
	    FlowLayout experimentLayout = new FlowLayout();
	    frame.setLayout(experimentLayout);
		frame.getContentPane().add(imagePanel);
		frame.getContentPane().add(buttonPanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(viewWidth, viewHeight);
		frame.setVisible(true);
		frame.setFocusable(true);
		// Set focus on the panel
		this.requestFocus();
		frame.repaint();
	}
	protected void paintComponent(Graphics g) {
		// Draw the background image
		g.drawImage(background, 0, 0, null, this);
	}
	
    // Action Listener for Start/Stop Button
    public void addStartListener(ActionListener start) {
    	startButton.addActionListener(start);
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

