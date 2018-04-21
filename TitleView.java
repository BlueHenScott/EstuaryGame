import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
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
	
	public TitleView() {

		JPanel buttonPanel = new JPanel(new GridLayout(1,2,4,4));
	    buttonPanel.add(startButton);	
			
		// Set up the JFrame
		
		frame = new JFrame();
		frame.setBackground(Color.blue);
		frame.getContentPane().add(this, BorderLayout.CENTER);
		frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);
		frame.getContentPane().setBackground(Color.blue);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		frame.setSize(viewWidth, viewHeight);
		frame.setVisible(true);
		frame.setFocusable(true);
	}
    // Action Listener for Start/Stop Button
    public void addStartListener(ActionListener start) {
    	startButton.addActionListener(start);
    }
}

