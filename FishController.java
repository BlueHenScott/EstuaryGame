import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class FishController {
	// Instances of Model and View for Fish
	private FishModel model;
	private FishView view;
	
	// Delay in the drawing
	private int drawDelay = 30;
	
	// Action to be completed in the timer
	private Action drawAction;
	
	
	public FishController() {
		/*
		 * TO-DO
		 * grab frame from titleScreen
		 */
		
		JFrame frame;
		frame = new JFrame();
		
		// Initialize model and view, passing in our frame
		model = new FishModel();
		view = new FishView(frame);
		// Add the keyListener to View
		view.addKeyInput(new KeyInput());
		
		// Create the action that occurs every cycle
		drawAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				model.update();
				view.update(model.getFishList(), model.getPlayerX(), model.getPlayerY());
			}
		};
	}
	// Start the cycle
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Timer t = new Timer(drawDelay, drawAction);
				t.start();
			}
		});
	}
	// Listens for keyInput
	class KeyInput implements KeyListener{
		@Override
		public void keyPressed(KeyEvent keyEvent) {
						
		}
		@Override
		public void keyReleased(KeyEvent keyEvent) {
			
		}
		@Override
		public void keyTyped(KeyEvent keyEvent) {
			// Key Typed should allow for the keys to be held down.
			int code = keyEvent.getKeyCode();
			switch (code) {
				case 38:
					model.moveUp();
					break;
				case 37:
					model.moveLeft();
					break;
				case 39:
					model.moveRight();
					break;
				case 40:
					model.moveDown();
					break;
				default:
					break;
			}
		
		}
	}
}
