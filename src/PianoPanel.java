import java.io.IOException;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class PianoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static PianoMainFrame frame;
	private static AllPanels panels;
	private JTextField txtPianoPanel;

	public PianoPanel(PianoMainFrame mainFrame, AllPanels allPanels)
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
		container.setBackground(new Color(102, 205, 170));
		add(container, "containerOne");
		container.setLayout(null);

		txtPianoPanel = new JTextField();
		txtPianoPanel.setText("piano panel");
		txtPianoPanel.setBounds(431, 183, 86, 20);
		container.add(txtPianoPanel);
		txtPianoPanel.setColumns(10);

		GuiFactory.addPianoBlackButton(container, "black key", 0, 5,
				new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

					}
				});

	
	GuiFactory.addPianoWhiteButton(container, "white key", 0, 5,
			new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

				}
			});

}
}
