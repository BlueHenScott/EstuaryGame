import java.awt.BorderLayout;
import java.awt.Color;
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
	private final int viewWidth = 1500;
	private final int viewHeight = 900;
	

	private BufferedImage background;
	
	private JFrame frame;
	private JButton startButton = new JButton("Start");
	
	public TitleView(JFrame f) {
	
		
		startButton.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JPanel buttonPanel = new JPanel(new GridLayout(1,2,4,4));
	    buttonPanel.add(startButton);	

		String backgroundLoc = "images/titlescreen.png";
		background = createImage(backgroundLoc);

		

	    JPanel imagePanel = new JPanel (new GridLayout());
	    JLabel picLabel = new JLabel(new ImageIcon(background.getScaledInstance(viewWidth, viewHeight, Image.SCALE_SMOOTH)));
	    imagePanel.add(picLabel);
		
		frame = f;
		frame.getContentPane().removeAll();
		
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
		frame.getContentPane().add(imagePanel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		frame.setSize(viewWidth, viewHeight);
		frame.setVisible(true);
		frame.setFocusable(true);
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