import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.Timer;

public class FishController {
	// Create instances of Model and View
	private FishModel model;
	private FishView view;
	
	private int drawDelay = 50;
	private Action drawAction;
	
	
	public FishController() {
		JFrame frame;
		frame = new JFrame();
		
		model = new FishModel();
		view = new FishView(frame);
		
		view.addKeyInput(new KeyInput());
		
		drawAction = new AbstractAction() {
			public void actionPerformed(ActionEvent e) {
				model.update();
				view.update(model.getFishList(), model.getPlayerX(), model.getPlayerY());
			}
		};
	}
	
	public void start() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Timer t = new Timer(drawDelay, drawAction);
				t.start();
			}
		});
	}
	class KeyInput implements KeyListener{
		@Override
		public void keyPressed(KeyEvent keyEvent) {
						
		}
		@Override
		public void keyReleased(KeyEvent keyEvent) {
			
		}
		@Override
		public void keyTyped(KeyEvent keyEvent) {
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

