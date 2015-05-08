import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class WelcomePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static PianoMainFrame frame;
	private static AllPanels panels;
	private JTextField txtWelcomepanel;

	public WelcomePanel(PianoMainFrame mainFrame, AllPanels allPanels)
			throws IOException {
		setLayout(null);

		// adds the PianoMainFrame
		frame = mainFrame;
		panels = allPanels;

		// defines the panel dimensions
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(800, 480));
		setBackground(SystemColor.textHighlight);
		// card layout is very important when adding the panels to the main
		// frame
		setLayout(new CardLayout(0, 0));

		// add all buttons, labels, etc., to this JPanel(container)
		JPanel container = new JPanel();
		container.setSize(800, 300);
		container.setBackground(new Color(127, 255, 212));
		add(container, "containerOne");
		container.setLayout(null);
		
		txtWelcomepanel = new JTextField();
		txtWelcomepanel.setText("WelcomePanel");
		txtWelcomepanel.setBounds(222, 155, 86, 20);
		container.add(txtWelcomepanel);
		txtWelcomepanel.setColumns(10);
		
		GuiFactory.addButton(container, "welcome", 200, 300, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			panels.getWelcomePanel().setVisible(false);
			panels.getPianoPanel().setVisible(true);

			}
		});

	}
}
