import javax.swing.JFrame;

@SuppressWarnings("serial")
public class TitleMain {
	private static JFrame frame;
	public static void main(String[] args) {
		// Create and start a new Controller
		frame = new JFrame();
		TitleController con = new TitleController(frame);
		
	}
}