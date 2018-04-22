import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class MGController {
	
	private MGModel model;
	private MGView view;
	private boolean isStarted = false;
	
	public MGController(JFrame frame){
		// Create new instances of Model and View
		view = new MGView(frame);
		model = new MGModel(view.getWidth(), view.getHeight()); //view.getImageWidth(), view.getImageHeight());
		
		view.addClickListener(new ClickListener());
	}

	public void start() {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				
				
			}
		});
		
	}
	
	class ClickListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			Point clickLocation = e.getLocationOnScreen();
			model.flipClicked(clickLocation);
			model.isMatch();
			view.refocus();  
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
