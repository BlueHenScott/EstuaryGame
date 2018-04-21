import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class TitleController {
	// Create instances of the Model and View classes
	private TitleView tView;
	private boolean isStarted = false;
	
	public TitleController(){
		// Create new instances of Model and View
		tView = new TitleView();
		
		tView.addStartListener(new StartListener());
	}
	class StartListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			isStarted = !isStarted;
		}

	}
}