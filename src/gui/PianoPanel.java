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
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;

import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class PianoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private static PianoMainFrame frame;
	private static AllPanels panels;
	private JTextField txtPianoPanel;
	private JTextField txtRecording;
	private JTextField txtOnOrOff;
	

	
	private JMenuBar menuBar = new JMenuBar(); 
	private JMenuItem newItem, openItem, closeItem, saveItem, saveAsItem,
			printItem;

	

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

		// Menu Bar

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 800, 30);
		container.add(toolBar);

		JPanel menuPanel = new JPanel();
		menuPanel.setBounds(0, 30, 800, 50);
		container.add(menuPanel);
		menuPanel.setLayout(null);

		JMenu fileMenu = new JMenu("File");
		JMenu elementMenu = new JMenu("Elements");
		newItem = fileMenu.add("New");
		openItem = fileMenu.add("Open");
		closeItem = fileMenu.add("Close");
		fileMenu.addSeparator();
		saveItem = fileMenu.add("Save");
		saveAsItem = fileMenu.add("Save As...");
		fileMenu.addSeparator();
		printItem = fileMenu.add("Quit");
		ButtonGroup types = new ButtonGroup();
		elementMenu.addSeparator();
		menuBar.add(fileMenu);
		toolBar.add(menuBar);

		// Menu Panel

		JButton btnStart = new JButton("start");
		btnStart.setBounds(10, 11, 89, 23);
		menuPanel.add(btnStart);

		JButton btnPause = new JButton("pause");
		btnPause.setBounds(109, 11, 89, 23);
		menuPanel.add(btnPause);

		JButton btnStop = new JButton("stop");
		btnStop.setBounds(208, 11, 89, 23);
		menuPanel.add(btnStop);

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
		PianoPanelTwo.setBounds(85, 26, 595, 258);
		pianoPanel.add(PianoPanelTwo);
		PianoPanelTwo.setLayout(null);

		JPanel blackKey_1 = new JPanel();
		blackKey_1.setBackground(Color.BLACK);
		blackKey_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("3");
			}
		});
		blackKey_1.setBounds(55, 0, 55, 110);
		PianoPanelTwo.add(blackKey_1);

		JPanel blackKey_2 = new JPanel();
		blackKey_2.setBackground(Color.BLACK);
		blackKey_2.setBounds(137, 0, 58, 110);
		PianoPanelTwo.add(blackKey_2);

		JPanel blackKey_3 = new JPanel();
		blackKey_3.setBackground(Color.BLACK);
		blackKey_3.setBounds(310, 0, 58, 110);
		PianoPanelTwo.add(blackKey_3);

		JPanel blackKey_4 = new JPanel();
		blackKey_4.setBackground(Color.BLACK);
		blackKey_4.setBounds(395, 0, 58, 110);
		PianoPanelTwo.add(blackKey_4);

		JPanel blackKey_5 = new JPanel();
		blackKey_5.setBackground(Color.BLACK);
		blackKey_5.setBounds(480, 0, 58, 110);
		PianoPanelTwo.add(blackKey_5);

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

		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBackground(Color.BLUE);
		panel_4.setBounds(169, 0, 85, 258);
		PianoPanelTwo.add(panel_4);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(254, 0, 85, 258);
		PianoPanelTwo.add(panel_5);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(Color.ORANGE);
		panel_6.setBounds(339, 0, 85, 258);
		PianoPanelTwo.add(panel_6);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBackground(Color.GREEN);
		panel_7.setBounds(424, 0, 85, 258);
		PianoPanelTwo.add(panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBackground(Color.MAGENTA);
		panel_8.setBounds(509, 0, 85, 258);
		PianoPanelTwo.add(panel_8);
		//
		// JPanel panel_1 = new JPanel();
		// panel_1.setBounds(47, 0, 90, 119);
		// PianoPanelTwo.add(panel_1);
		// panel_1.setLayout(null);
		//
		// JButton btnNewButton_1 = new JButton("New button");
		// btnNewButton_1.setBounds(0, 0, 89, 119);
		// panel_1.add(btnNewButton_1);
		//
		// JButton btnNewButton = new JButton("New button");
		// btnNewButton.setBounds(0, 0, 90, 258);
		// PianoPanelTwo.add(btnNewButton);
		//
		// JButton button = new JButton("New button");
		// button.setBounds(91, 0, 90, 258);
		// PianoPanelTwo.add(button);
		//
		// JButton button_1 = new JButton("New button");
		// button_1.setBounds(176, 0, 90, 258);
		// PianoPanelTwo.add(button_1);

		JPanel bottomPanel = new JPanel();
		bottomPanel.setBounds(0, 390, 800, 50);
		container.add(bottomPanel);
		bottomPanel.setLayout(null);

		txtRecording = new JTextField();
		txtRecording.setText("Recording");
		txtRecording.setBounds(339, 11, 86, 20);
		bottomPanel.add(txtRecording);
		txtRecording.setColumns(10);

		txtOnOrOff = new JTextField();
		txtOnOrOff.setText("on or off");
		txtOnOrOff.setBounds(245, 11, 86, 20);
		bottomPanel.add(txtOnOrOff);
		txtOnOrOff.setColumns(10);

		// GuiFactory.addPianoBlackButton(container, "black key", 0, 5,
		// new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		//
		// }
		// });
		//
		//
		// GuiFactory.addPianoWhiteButton(container, "white key", 0, 5,
		// new ActionListener() {
		//
		// @Override
		// public void actionPerformed(ActionEvent e) {
		//
		// }
		// });

	}

}