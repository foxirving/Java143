package gui;

import java.io.IOException;

import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

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

		//Menu Bar
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 800, 30);
		container.add(toolBar);

		JButton btnFile = new JButton("File");
		btnFile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		toolBar.add(btnFile);
		
		
		//Menu Panel
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 30, 800, 50);
		container.add(menuPanel);
		menuPanel.setLayout(null);
		
		
		JPanel pianoPanel = new JPanel();
		pianoPanel.setBackground(Color.GRAY);
		pianoPanel.setBounds(0, 80, 800, 310);
		container.add(pianoPanel);
		pianoPanel.setLayout(null);
		
		JPanel stylePanelOne = new JPanel();
		stylePanelOne.setBackground(Color.CYAN);
		stylePanelOne.setBounds(0, 0, 800, 15);
		pianoPanel.add(stylePanelOne);
		stylePanelOne.setLayout(null);
		
		JPanel stylePanelTwo = new JPanel();
		stylePanelTwo.setLayout(null);
		stylePanelTwo.setBackground(Color.CYAN);
		stylePanelTwo.setBounds(0, 295, 800, 15);
		pianoPanel.add(stylePanelTwo);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(0, 390, 800, 50);
		container.add(bottomPanel);
		bottomPanel.setLayout(null);

//		GuiFactory.addPianoBlackButton(container, "black key", 0, 5,
//				new ActionListener() {
//
//					@Override
//					public void actionPerformed(ActionEvent e) {
//
//					}
//				});
//
//	
//	GuiFactory.addPianoWhiteButton(container, "white key", 0, 5,
//			new ActionListener() {
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//
//				}
//			});

}
}
