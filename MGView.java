import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MGView extends JPanel{
	private final int viewWidth = 1500;
	private final int viewHeight = 900;
	private JFrame frame;
	private JPanel apanel; 
	private JPanel epanel; 
	ArrayList<ImageIcon> ecards = new ArrayList<ImageIcon>(); //environment cards
	ArrayList<ImageIcon> acards = new ArrayList<ImageIcon>(); //animals cards
	
	public MGView(JFrame f) {
		try {
			addIcons();
			System.out.println("items adde");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		apanel = new JPanel();
		apanel.setLayout(new GridLayout(3,2));
		epanel = new JPanel();
		epanel.setLayout(new GridLayout(3,2));
		
		
		frame = f;
		f.getContentPane().removeAll();
		
		frame.setBackground(Color.gray);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		frame.setSize(viewWidth, viewHeight);
		frame.setVisible(true);
		frame.setFocusable(true);
		
		frame.setLayout(new GridLayout(1,2));
		this.drawCards();
		frame.getContentPane();
		//frame.getContentPane().add(apanel, BorderLayout.CENTER);
		
		frame.add(apanel);
		frame.add(epanel);


		apanel.setVisible(true);
		epanel.setVisible(true);
		
		frame.repaint();
	}

	private void drawCards() {
		for (ImageIcon img: acards) {
			JLabel label = new JLabel(img);
			apanel.add(label);
		}
		for (ImageIcon img: ecards) {
			JLabel label = new JLabel(img);
			epanel.add(label);
		}
		
	}

	private void addIcons() throws IOException {
		
		for (int i= 0; i < 6; i++) {
			ImageIcon animal = new ImageIcon("images/animals/animal.png");// + i);
			ImageIcon enviromnet = new ImageIcon("images/environments/environment.png");// + i);
			acards.add(animal);
			ecards.add(enviromnet);
		}
		
		
		
		
		
		
//		for (int i = 0; i < 6; i++) {
//			Image animal = ImageIO.read(new File("images/animals/animal" + i));
//			acards.add(animal);
//			Image environment = ImageIO.read(new File("images/environment/environemnt" + i));
//			acards.add(environment);
//			
//			
//		}
		
		
		
	}
	//this does not get used... YET! (it actually probably wont)
	private Image createImage(String loc){
    	BufferedImage bufferedImage;
    	try {
    		bufferedImage = ImageIO.read(new File(loc));
    		return bufferedImage;
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    	return null;
    	
    }
	public void addClickListener(MouseListener flip) {
		frame.addMouseListener(flip);
	}
}
