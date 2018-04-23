import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
	
	
	private JFrame frame;
	private JButton startButton = new JButton("Start");
	
	public TitleView(JFrame f) {
	
		JPanel buttonPanel = new JPanel(new GridLayout(1,2,4,4));
	    buttonPanel.add(startButton);	
			
		JPanel newPanel = new JPanel(new GridBagLayout());
		JLabel label = new JLabel("Estuary Extravaganza");
		newPanel.add(label);
		// Set up the JFrame
		
		frame = f;
		frame.getContentPane().removeAll();
		
		frame.getContentPane().setBackground(Color.CYAN);
		frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
		frame.getContentPane().add(newPanel);
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

