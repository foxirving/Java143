package gui;
import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;



public class PianoMainFrame {

	private JFrame frame;
	static AllPanels allPanels;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PianoMainFrame window = new PianoMainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public PianoMainFrame() throws IOException {
		initialize();
		
		allPanels = new AllPanels(this);
		
		frame.getContentPane().add(AllPanels.getWelcomePanel());
		AllPanels.getWelcomePanel().setVisible(true);
		
		frame.getContentPane().add(AllPanels.getPianoPanel());
		AllPanels.getPianoPanel().setVisible(false);

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new CardLayout(0, 0));
	}


}
