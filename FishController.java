import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Action;
import javax.swing.JFrame;

public class FishController {
	// Create instances of Model and View
	private FishModel model;
	private FishView view;
	
	int drawDelay;
	
	public FishController() {
		JFrame frame;
		frame = new JFrame();
		
		model = new FishModel();
		view = new FishView(frame);
		
		view.addKeyInput(new KeyInput());
	}
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
		
	}
}
