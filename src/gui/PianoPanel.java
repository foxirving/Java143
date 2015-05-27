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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
		
		JPanel PianoPanelTwo = new JPanel();
		PianoPanelTwo.setBounds(85, 26, 630, 258);
		pianoPanel.add(PianoPanelTwo);
		PianoPanelTwo.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("3");
			}
		});
		panel_3.setBounds(44, 0, 83, 110);
		PianoPanelTwo.add(panel_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("2");
			}
		});
		panel_2.setBackground(Color.ORANGE);
		panel_2.setBounds(84, 0, 85, 258);
		PianoPanelTwo.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("1");
			}
		});
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(0, 0, 85, 258);
		PianoPanelTwo.add(panel_1);
		panel_1.setLayout(null);
//		
//		JPanel panel_1 = new JPanel();
//		panel_1.setBounds(47, 0, 90, 119);
//		PianoPanelTwo.add(panel_1);
//		panel_1.setLayout(null);
//		
//		JButton btnNewButton_1 = new JButton("New button");
//		btnNewButton_1.setBounds(0, 0, 89, 119);
//		panel_1.add(btnNewButton_1);
//		
//		JButton btnNewButton = new JButton("New button");
//		btnNewButton.setBounds(0, 0, 90, 258);
//		PianoPanelTwo.add(btnNewButton);
//		
//		JButton button = new JButton("New button");
//		button.setBounds(91, 0, 90, 258);
//		PianoPanelTwo.add(button);
//		
//		JButton button_1 = new JButton("New button");
//		button_1.setBounds(176, 0, 90, 258);
//		PianoPanelTwo.add(button_1);
		
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
