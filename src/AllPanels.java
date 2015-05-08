import java.io.IOException;



public class AllPanels {
	
	private static PianoMainFrame frame;
	private static WelcomePanel welcomePanel;
	private static PianoPanel pianoPanel;
	
	
	public static WelcomePanel getWelcomePanel() {
		return welcomePanel;
	}

	public static PianoPanel getPianoPanel() {
		return pianoPanel;
	}

	public AllPanels(PianoMainFrame mainFrame) throws IOException{
		
		//create variables for each panel
		frame = mainFrame;
		
		pianoPanel = new PianoPanel(frame, this);
		
		welcomePanel = new WelcomePanel(frame, this);
		
	}

}
